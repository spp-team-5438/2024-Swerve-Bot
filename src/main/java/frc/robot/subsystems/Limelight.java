package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.cscore.VideoSource;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Limelight {
    NetworkTable table;
    NetworkTableEntry tx, ty, ta;
    double x, y, area;
    
    public Limelight() {
        updateValues();
    }

    public void updateValues() {
        table = NetworkTableInstance.getDefault().getTable("limelight");

        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");

        x = tx.getDouble(69.69);
        y = ty.getDouble(69.69);
        area = ta.getDouble(69.69);
    }

    public void logToSmartDashboard() {
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        // SmartDashboard.put("limelightCam", "limelight", "http://10.54.38.81:5800");
    }
}