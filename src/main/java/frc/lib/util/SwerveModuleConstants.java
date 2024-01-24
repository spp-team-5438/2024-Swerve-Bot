package frc.lib.util;

import edu.wpi.first.math.geometry.Rotation2d;

public class SwerveModuleConstants {
    public final int driveMotorID;
    public final int angleMotorID;
    public final int encoderId;
    public final Rotation2d angleOffset;

    /**
     * Swerve Module Constants to be used when creating swerve modules.
     * @param driveMotorID
     * @param angleMotorID
     * @param encoderID
     * @param angleOffset
     */
    public SwerveModuleConstants(int driveMotorID, int angleMotorID,
        int encoderID, Rotation2d angleOffset)
    {
        this.driveMotorID = driveMotorID;
        this.angleMotorID = angleMotorID;
        this.encoderId = encoderID;
        this.angleOffset = angleOffset;
    }
}
