package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    public static CANSparkMax intakeMotor;
    static AnalogInput analog = new AnalogInput(0);
    public static double currentVoltage = analog.getVoltage();
    
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(Constants.intakeMotorID, MotorType.kBrushless);
    }

    public static void stopMotor() {
        intakeMotor.set(0);
    }
}