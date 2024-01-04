package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleboardSubsystem {
   public double sp;

   // makes a new tab for all the controls
   private ShuffleboardTab tab = Shuffleboard.getTab("controls");
   public GenericEntry speed =
      tab.add("speedEntry", 1.6)
         .getEntry();

   // gets the value of speed divisor
   public double foo() {
      return speed.getDouble(1.0);
   }

   }

