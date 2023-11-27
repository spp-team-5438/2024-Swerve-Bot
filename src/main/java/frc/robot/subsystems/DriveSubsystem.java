package frc.robot.subsystems;

import frc.robot.subsystems.SwerveModule;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase { 
    private final SwerveModule frontLeft;
    private final SwerveModule frontRight;
    private final SwerveModule backLeft;
    private final SwerveModule backRight;

    public DriveSubsystem()
    {
        frontLeft = new SwerveModule(Constants.frontL[0], Constants.frontL[1]);
        frontRight = new SwerveModule(Constants.frontR[0], Constants.frontR[1]);
        backLeft = new SwerveModule(Constants.backL[0], Constants.backL[1]);
        backRight = new SwerveModule(Constants.backR[0], Constants.backR[1]);
    }

    @Override
    public void periodic()
    {}

    public void stopModules()
    {
        frontLeft.stop();
        frontRight.stop();
        backLeft.stop();
        backRight.stop();
    }

    public void setModuleStates(SwerveModuleState[] desiredStates)
    {
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, 4.5);
        frontLeft.setDesiredState(desiredStates[0]);
        frontRight.setDesiredState(desiredStates[1]);
        backLeft.setDesiredState(desiredStates[2]);
        backRight.setDesiredState(desiredStates[3]);
    }
}