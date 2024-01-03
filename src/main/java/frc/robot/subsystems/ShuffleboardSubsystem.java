package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShuffleboardSubsystem {
   public double sp;

   class tabulator { 
      private ShuffleboardTab tab = Shuffleboard.getTab("controls");
      public GenericEntry speed =
         tab.add("speedEntry", 1.6)
            .getEntry();

      public double foo() {
         return speed.getDouble(1.0);
      }

   }
}
