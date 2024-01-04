package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import pabeles.concurrency.IntOperatorTask.Min;
import java.util.Map;

public class ShuffleboardSubsystem {
   public double sp;

   // makes a new tab for all the controls
   private ShuffleboardTab tab = Shuffleboard.getTab("controls");
   public GenericEntry speed =
      tab.add("speed divisor", 1.6).withWidget(BuiltInWidgets.kNumberSlider)
         .withProperties(Map.of("min", 1, "max", 3, "blockIncrement", 0.1))
         .getEntry();

   // gets the value of speed divisor
   public double foo() {
      return speed.getDouble(1.0);
   }
 }

