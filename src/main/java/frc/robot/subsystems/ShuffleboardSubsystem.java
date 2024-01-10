package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import java.util.Map;
import frc.robot.Constants;

public class ShuffleboardSubsystem {
   Constants cons = new Constants();
   public double sp;

   public static ShuffleboardSubsystem Instance;

   public ShuffleboardSubsystem()
   {
      if (Instance == null)
         Instance = this;
   }

   // makes a new tab for all the controls
   private ShuffleboardTab tab = Shuffleboard.getTab("controls");
   public GenericEntry speed =
      tab.add("speed divisor", 1.6).withWidget(BuiltInWidgets.kNumberSlider)
         .withProperties(Map.of("min", 1, "max", 3, "blockIncrement", 0.1))
         .withPosition(0, 0)
         .getEntry();
         
   public GenericEntry deadBandXL =
      tab.add("deadBand ChangeXL", Constants.deadBand.stickXL).withWidget(BuiltInWidgets.kNumberSlider)
         .withProperties(Map.of("min", 0, "max", 0.5, "blockIncrement", 0.01))
         .withPosition(0, 1)
         .getEntry(); 

   public GenericEntry deadBandYL =
      tab.add("deadBand ChangeYL", Constants.deadBand.stickYL).withWidget(BuiltInWidgets.kNumberSlider)
         .withProperties(Map.of("min", 0, "max", 0.5, "blockIncrement", 0.01))
         .withPosition(0, 2)
         .getEntry();

   public GenericEntry deadBandXR =
      tab.add("deadBand ChangeXR", Constants.deadBand.stickXR).withWidget(BuiltInWidgets.kNumberSlider)
         .withProperties(Map.of("min", 0, "max", 0.5, "blockIncrement", 0.01))
         .withPosition(0, 3)
         .getEntry();

   public GenericEntry deadBandYR =
      tab.add("deadBand ChangeYR", Constants.deadBand.stickYR).withWidget(BuiltInWidgets.kNumberSlider)
         .withProperties(Map.of("min", 0, "max", 0.5, "blockIncrement", 0.01))
         .withPosition(0, 4)
         .getEntry();

   // gets the value of any entry you pass to it 
   public double getEntry(GenericEntry get, double baseValue) {
      return get.getDouble(baseValue);
   }

   // sets the value of any entry you pass to it
   public void setEntry(GenericEntry set, double value) {
      set.setDouble(value);
   }
 }

