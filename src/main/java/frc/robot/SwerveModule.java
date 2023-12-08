package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import frc.lib.math.Conversions;
import frc.lib.util.CTREModuleState;
import frc.lib.util.SwerveModuleConstants;

public class SwerveModule {
    private PIDController anglePidController;
    public int moduleNumber;
    private Rotation2d angleOffset;
    private Rotation2d lastAngle;

    private CANSparkMax mAngleMotor;
    private CANSparkMax mDriveMotor;
    private SparkMaxPIDController pidController;
    private RelativeEncoder mAngleEncoder;
    private RelativeEncoder mDriveEncoder;
    // private CANCoder angleEncoder;
    private AnalogInput angleEncoder;

    SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(
        Constants.Swerve.driveKS,
        Constants.Swerve.driveKV,
        Constants.Swerve.driveKA
    );

    public SwerveModule(int moduleNumber, SwerveModuleConstants moduleConstants)
    {
        anglePidController = new PIDController(0.1, 0.0, 0.0);
        this.moduleNumber = moduleNumber;
        this.angleOffset = moduleConstants.angleOffset;
        
        /* Angle Encoder Config */
        angleEncoder = new AnalogInput(moduleConstants.encoderId);

        /* Angle Motor Config */
        mAngleMotor = new CANSparkMax(moduleConstants.angleMotorID, MotorType.kBrushless);
        pidController = mAngleMotor.getPIDController();
        pidController.setP(0.3);
        pidController.setI(0.0);
        pidController.setD(0.0);
        pidController.setOutputRange(-1, 1);
        mAngleEncoder = mAngleMotor.getEncoder();
        configAngleMotor();

        /* Drive Motor Config */
        mDriveMotor = new CANSparkMax(moduleConstants.driveMotorID, MotorType.kBrushless);
        configDriveMotor();
        mDriveEncoder = mDriveMotor.getEncoder();

        lastAngle = getState().angle;
    }
    
    public double getOutput()
    {
        return mAngleMotor.get();
    }

    public void setDesiredState(SwerveModuleState desiredState)
    {
        /* This is a custom optimize function, since default WPILib optimize
         * assumes continuous controller which CTRE and Rev onboard is not
         */
        desiredState = CTREModuleState.optimize(desiredState, getState().angle); 
        setAngle(desiredState);
        setSpeed(desiredState);
    }

    private void setSpeed(SwerveModuleState desiredState)
    {
        double percentOutput = desiredState.speedMetersPerSecond
            / Constants.Swerve.maxSpeed;
        mDriveMotor.set(percentOutput);
    }

    private void setAngle(SwerveModuleState desiredState)
    {
        // Prevent rotating module if speed is less then 1%. Prevents Jittering.
        Rotation2d angle = (Math.abs(desiredState.speedMetersPerSecond) <= 
            (Constants.Swerve.maxSpeed * 0.01)) ?
            lastAngle : desiredState.angle;

        double output = anglePidController.calculate(
            mAngleEncoder.getPosition(), Conversions.degreesToSparkMax(
                angle.getDegrees(),
                Constants.Swerve.angleGearRatio));
        mAngleMotor.set(output);
        lastAngle = angle;
    }

    public Rotation2d getAngle()
    {
        return Rotation2d.fromDegrees(Conversions.SparkMaxToDegrees(
            mAngleEncoder.getPosition(), Constants.Swerve.angleGearRatio));
    }

    public Rotation2d getEncoder()
    {
        return Rotation2d.fromRadians((angleEncoder.getVoltage()
            / RobotController.getVoltage5V()) * 2 * Math.PI);
    }

    public void resetToAbsolute()
    {
        double absolutePosition = Conversions.degreesToSparkMax(
            getEncoder().getDegrees() - angleOffset.getDegrees(),
            Constants.Swerve.angleGearRatio);
        mAngleEncoder.setPosition(absolutePosition);
    }

    private void configAngleMotor()
    {
        mAngleMotor.restoreFactoryDefaults();
        // mAngleMotor.configAllSettings(Robot.ctreConfigs.swerveAngleFXConfig);
        mAngleMotor.setInverted(Constants.Swerve.angleMotorInvert);
        mAngleMotor.setIdleMode(Constants.Swerve.angleNeutralMode);
        resetToAbsolute();
    }

    private void configDriveMotor()
    {
        mDriveMotor.restoreFactoryDefaults();
        // mDriveMotor.configAllSettings(Robot.ctreConfigs.swerveDriveFXConfig);
        mDriveMotor.setInverted(Constants.Swerve.driveMotorInvert);
        mDriveMotor.setIdleMode(Constants.Swerve.driveNeutralMode);
        // mDriveMotor.setSelectedSensorPosition(0);
    }

    public SwerveModuleState getState()
    {
        return new SwerveModuleState(Conversions.sparkMaxToMPS(
            mDriveEncoder.getVelocity(),
            Constants.Swerve.wheelCircumference,
            Constants.Swerve.driveGearRatio), 
            getAngle()
        ); 
    }

    public SwerveModulePosition getPosition()
    {
        return new SwerveModulePosition(
            Conversions.sparkMaxToMeters(mDriveEncoder.getPosition(),
            Constants.Swerve.wheelCircumference, Constants.Swerve.driveGearRatio), 
            getAngle()
        );
    }
}
