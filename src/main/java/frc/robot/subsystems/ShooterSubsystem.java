package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.AutoAimCommand;

import frc.robot.Constants;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import frc.lib.math.Conversions;

public class ShooterSubsystem extends SubsystemBase {
    public boolean isAutoRunning = false; // Controlled by driver

    //Speaker Shooter---------------------------------------------------------------------------------------------

    public CANSparkMax speakerMotorTop = new CANSparkMax(Constants.shooterMotorTopID, MotorType.kBrushless);
    public CANSparkMax speakerMotorBottom = new CANSparkMax(Constants.shooterMotorBottomID, MotorType.kBrushless);
    public CANSparkMax pistonMotor = new CANSparkMax(0, MotorType.kBrushless);

    private PIDController pistonPIDController = new PIDController(0, 0, 0);
    private SparkMaxAbsoluteEncoder pistonEncoder = pistonMotor.getAbsoluteEncoder(Type.kDutyCycle);

    // Amp Shooter-------------------------------------------------------------------------------------------------

    public CANSparkMax ampWheelMotor = new CANSparkMax(Constants.ampMotorID, MotorType.kBrushless);
    public CANSparkMax ampRotationMotor = new CANSparkMax(0, MotorType.kBrushless);
    
    //-------------------------------------------------------------------------------------------------------------

    public void setSpeakerAngle(double desiredAngle)
    {
        double output = pistonPIDController.calculate(pistonEncoder.getPosition(), Conversions.degreesToSparkMax(desiredAngle, 0)); // TODO: Get gear ratio
        pistonMotor.set(output);
    }

    public double getSpeakerAngle()
    {
        // TODO: everything
        return 0;
    }

    public void setSpeakerMotor(double desiredSpeed)
    {
        speakerMotorTop.set(desiredSpeed);
        speakerMotorBottom.set(desiredSpeed);
    }

    public double getSpeakerMotor()
    {
        return 0;
    }

    public void setAmpAngle(double desiredSpeed)
    {
        ampRotationMotor.set(desiredSpeed);
    }

    public double getAmpAngle()
    {
        return 0;
    }

    public void setAmpMotor(double desiredSpeed)
    {
        ampWheelMotor.set(desiredSpeed);
    }

    public double getAmpMotor()
    {
        return 0;
    }

    public Command startAutoAim()
    {
        return new AutoAimCommand(this, 0); // TODO: Get distance from somewhere
    }
}
