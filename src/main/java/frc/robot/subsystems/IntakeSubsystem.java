package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    public CANSparkMax intakeMotor;
    
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(Constants.intakeMotorID, MotorType.kBrushless);
    }
}