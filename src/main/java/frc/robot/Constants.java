// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import frc.robot.components.*;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static Motor[] frontL = {
    new Motor(3, MotorType.kBrushless, false), /* movement motor */
    new Motor(2, MotorType.kBrushless, false)  /* turning motor */
  };
  public static Motor[] frontR = {
    new Motor(5, MotorType.kBrushless, false), /* movement motor */
    new Motor(4, MotorType.kBrushless, false)  /* turning motor */
  };
  public static Motor[] backL = {
    new Motor(1, MotorType.kBrushless, false), /* movement motor */
    new Motor(8, MotorType.kBrushless, false)  /* turning motor */
  };
  public static Motor[] backR = {
    new Motor(7, MotorType.kBrushless, false), /* movement motor */
    new Motor(6, MotorType.kBrushless, false)  /* turning motor */
  };

  public static double deadband = 0.05;
  public static final double trackWidth = Units.inchesToMeters(26.25);
  public static final double wheelBase = Units.inchesToMeters(26.25);

  public static final SwerveDriveKinematics driveKinematics = new SwerveDriveKinematics(
    new Translation2d(wheelBase / 2, -trackWidth / 2),
    new Translation2d(wheelBase / 2, trackWidth / 2),
    new Translation2d(-wheelBase / 2, -trackWidth / 2),
    new Translation2d(-wheelBase / 2, trackWidth / 2)
  );



  public static class OperatorConstants {
    public static final int controllerPort = 1;
  };

  public static class DriverConstants {
    public static final int controllerPort = 0;
  }
}
