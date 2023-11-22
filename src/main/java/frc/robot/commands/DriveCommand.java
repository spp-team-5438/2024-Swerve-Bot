package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    public DriveSubsystem driveSubsystem;
    private ChassisSpeeds chassisSpeeds;
    private double xSpeed, ySpeed, turningSpeed;
    private SlewRateLimiter xLimiter, yLimiter, turningLimiter;

    private boolean fieldOriented;

    public DriveCommand(DriveSubsystem driveSubsystem, double xSpeed, double ySpeed,
        double turningSpeed, boolean fieldOriented)
    {
        this.driveSubsystem = driveSubsystem;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.turningSpeed = turningSpeed;
        this.fieldOriented = fieldOriented;

        turningLimiter = new SlewRateLimiter(0, 0, 0);
    }

    @Override
    public void execute()
    {
        //xSpeed = xSpeed > Constants.deadband ? xSpeed : 0.0;
        //ySpeed = ySpeed > Constants.deadband ? ySpeed : 0.0;
        //turningSpeed = Math.abs(turningSpeed) > Constants.deadband ? turningSpeed : 0.0;

        xSpeed = xSpeed / 100; //* 1.25;
        ySpeed = ySpeed / 100; //* 1.25;
        turningSpeed = turningLimiter.calculate(turningSpeed) / 100;// * ((2*2*3.1415926535) / 4);

        chassisSpeeds = new ChassisSpeeds(ySpeed, xSpeed, turningSpeed);

        SwerveModuleState[] moduleStates = Constants.driveKinematics.toSwerveModuleStates(chassisSpeeds);

        SmartDashboard.putNumber("xSpeed", xSpeed);
        SmartDashboard.putNumber("ySpeed", ySpeed);
        SmartDashboard.putNumber("turningSpeed", turningSpeed);
        driveSubsystem.setModuleStates(moduleStates);
    }
}