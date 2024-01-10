package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    public CANSparkMax motorL = new CANSparkMax(Constants.shooterMotorL, MotorType.kBrushless);
    public CANSparkMax motorR = new CANSparkMax(Constants.shooterMotorR, MotorType.kBrushless);
}
