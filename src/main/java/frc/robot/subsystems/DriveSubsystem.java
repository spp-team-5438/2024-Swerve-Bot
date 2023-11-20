package frc.robot.subsystems;

import frc.robot.subsystems.SwerveModule;
import frc.robot.Constants;

public class DriveSubsystem { 
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

    public void stopModule()
    {
        frontLeft.stop();
        frontRight.stop();
        backLeft.stop();
        backRight.stop();
    }
}