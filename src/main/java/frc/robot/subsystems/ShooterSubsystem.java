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
    public CANSparkMax speakerMotorPivot = new CANSparkMax(0, MotorType.kBrushless);

    private PIDController pistonPIDController = new PIDController(0, 0, 0);
    private DutyCycleEncoder pistonEncoder = new DutyCycleEncoder(Type.kDutyCycle);

    // Amp Shooter-------------------------------------------------------------------------------------------------

    public CANSparkMax ampWheelMotor = new CANSparkMax(Constants.ampMotorID, MotorType.kBrushless);
    public CANSparkMax ampRotationMotor = new CANSparkMax(0, MotorType.kBrushless);
    
    private SparkMaxAbsoluteEncoder ampEncoder = ampRotationMotor.getAbsoluteEncoder(Type.kDutyCycle);
    private PIDController ampPIDController = new PIDController(0, 0, 0);
    
    //-------------------------------------------------------------------------------------------------------------

    public void setSpeakerAngle(double desiredAngle)
    {
        double output = pivotPIDController.calculate(pivotEncoder.getPosition(), Conversions.degreesToSparkMax(desiredAngle, 0)); // TODO: Get gear ratio
        speakerMotorPivot.set(output);
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
     //   return speakerMotorBottom.get() + speakerMotorTop.get()
    }

    public void setAmpAngle(double desiredAngle)
    {
        double outputAngle = ampPIDController.calculate(ampEncoder.getPosition(), Conversions.degreesToSparkMax(desiredAngle, 0));
        ampRotationMotor.set(outputAngle);
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

    public Command onInit()
    {
        double absolutePosition = Conversions.degreesToSparkMax(
            getEncoder().getDegrees() - Constants.Shooter.angleOffset.getDegrees(), Constants.Shooter.pistonMotorID);
        pistonEncoder.setPosition(absolutePosition);
    }

}
