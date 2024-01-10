package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import frc.lib.math.Conversions;

public class ShooterSubsystem extends SubsystemBase {
    public boolean isAutoRunning = false; // Controlled by driver

    public CANSparkMax motorL = new CANSparkMax(Constants.shooterMotorL, MotorType.kBrushless);
    public CANSparkMax motorR = new CANSparkMax(Constants.shooterMotorR, MotorType.kBrushless);
    private CANSparkMax pistonMotor = new CANSparkMax(0, MotorType.kBrushless);

    private PIDController pistonPIDController = new PIDController(0, 0, 0);
    private SparkMaxAbsoluteEncoder pistonEncoder = pistonMotor.getAbsoluteEncoder(Type.kDutyCycle);

    public void setAngle(double desiredAngle)
    {
        double output = pistonPIDController.calculate(pistonEncoder.getPosition(), Conversions.degreesToSparkMax(desiredAngle, 0)); // TODO: Get gear ratio
        pistonMotor.set(output);
    }

    public double getAngle()
    {
        // TODO: everything
        return 0;
    }
}
