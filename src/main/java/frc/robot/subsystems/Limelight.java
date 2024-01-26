package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Limelight {
    double[] aprilTagPosition;
    // NetworkTableEntry tx, ty, tz;
    // double x, y, z;
    
    public Limelight() {
        updateValues();
    }

    public void updateValues() {
        // table = NetworkTableInstance.getDefault().getTable("limelight");

        // tx = table.getEntry("MegaTag BotPose TX");
        // ty = table.getEntry("MegaTag BotPose TY");
        // tz = table.getEntry("MegaTag BotPose TZ");
        

        // x = tx.getDouble(69.69);
        // y = ty.getDouble(69.69);
        // z = tz.getDouble(69.69);

        // SmartDashboard.putNumber("LimelightX", x);
        // SmartDashboard.putNumber("LimelightY", y);
        // SmartDashboard.putNumber("LimelightZ", z);
        aprilTagPosition = NetworkTableInstance.getDefault().getTable("limelight").getEntry("targetpose_cameraspace").getDoubleArray(new double[6]);
        SmartDashboard.putNumberArray("targetpose_cameraspace", aprilTagPosition);
        
    }
}