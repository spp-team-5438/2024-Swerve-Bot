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
        SmartDashboard.putNumber("xSpeed", xSpeed);
        SmartDashboard.putNumber("ySpeed", ySpeed);
        SmartDashboard.putNumber("turningSpeed", turningSpeed);

        xLimiter = new SlewRateLimiter(0, 0, 0);
        yLimiter = new SlewRateLimiter(0, 0, 0);
        turningLimiter = new SlewRateLimiter(0, 0, 0);
        addRequirements(driveSubsystem);
        execute();
    }

    @Override
    public void execute()
    {
        xSpeed = Math.abs(xSpeed) > Constants.deadband ? xSpeed : 0.0;
        ySpeed = Math.abs(ySpeed) > Constants.deadband ? ySpeed : 0.0;
        turningSpeed = Math.abs(turningSpeed) > Constants.deadband ? turningSpeed : 0.0;

        // xSpeed = xLimiter.calculate(xSpeed); // * ((2*2*3.1415926535) / 4);
        // ySpeed = yLimiter.calculate(ySpeed); // * ((2*2*3.1415926535) / 4);
        // turningSpeed = turningLimiter.calculate(turningSpeed); // * ((2*2*3.1415926535) / 4);

        chassisSpeeds = new ChassisSpeeds(ySpeed, xSpeed, turningSpeed);

        SwerveModuleState[] moduleStates = Constants.driveKinematics.toSwerveModuleStates(chassisSpeeds);

        driveSubsystem.setModuleStates(moduleStates);
    }

    /* override these to stop the motors from changing positions after the command starts and finishes */
    @Override
    public void initialize() {}

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}