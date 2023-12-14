package frc.robot.subsystems;

public class Shuffleboard {
    private ShuffleboardTab tab = Shuffleboard.getTab("Vision");
    private NetworkTableEntry distanceEntry =
       tab.add("Distance to target", 0)
          .getEntry();
}