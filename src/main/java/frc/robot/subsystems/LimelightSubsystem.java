package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

// USEFUL LINKS:
// Programming QuickStart - https://docs.limelightvision.io/docs/docs-limelight/getting-started/programming
// Network Tables API - https://docs.limelightvision.io/docs/docs-limelight/apis/complete-networktables-api

public class LimelightSubsystem extends SubsystemBase{

    NetworkTable limeLightTable;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;

    public LimelightSubsystem() {
        CameraServer.startAutomaticCapture();

        limeLightTable = NetworkTableInstance.getDefault().getTable("limelight");
        tx = limeLightTable.getEntry("tx");
        ty = limeLightTable.getEntry("ty");
        ta = limeLightTable.getEntry("ta");
    }

    public void smartDashboardUpdate() {
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
    }
}
