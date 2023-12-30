package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Shuffleboard {
   double sp;

   public Shuffleboard() {
      SmartDashboard.putNumber("pee", 5);
      double sp = SmartDashboard.getNumber("pee", 6996);
   }

   public void updateShufflboard() {
      SmartDashboard.putNumber("sp", sp);
   }
}