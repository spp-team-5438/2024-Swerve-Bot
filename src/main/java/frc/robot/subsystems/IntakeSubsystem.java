package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    public CANSparkMax intakeMotor = new CANSparkMax(Constants.IntakeConstants.intakeMotorID, MotorType.kBrushless);;
    public CANSparkMax feedMotor = new CANSparkMax(Constants.IntakeConstants.feedMotorID, MotorType.kBrushless);

    private AnalogInput analog = new AnalogInput(0);
    public double currentVoltage = analog.getVoltage();

    public void stopMotor() {
        intakeMotor.set(0);
    }

    public double getVoltage()
    {
        return analog.getVoltage();
    }
}