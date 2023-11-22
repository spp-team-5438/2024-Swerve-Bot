package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.components.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule {
    private CANSparkMax driveMotor;
    private CANSparkMax turnMotor;

    private RelativeEncoder driveEncoder;
    private RelativeEncoder turnEncoder;

    private boolean reversed;
    private double offset; 

    public SwerveModule(Motor movement, Motor rotate)
    {
        /* initialize motors */
        driveMotor = new CANSparkMax(movement.id, movement.type);
        turnMotor = new CANSparkMax(rotate.id, rotate.type);

        /* reset to default */
        driveMotor.restoreFactoryDefaults();
        turnMotor.restoreFactoryDefaults();

        /* initialize motor encoders */
        driveEncoder = driveMotor.getEncoder();
        turnEncoder = turnMotor.getEncoder();

        /* reverse motors */
        driveMotor.setInverted(movement.isReversed);
        turnMotor.setInverted(rotate.isReversed);

        driveMotor.burnFlash();
        turnMotor.burnFlash();

        driveEncoder.setPosition(0);
    }

    public void stop()
    {
        driveMotor.set(0);
        turnMotor.set(0);
    }

    public SwerveModuleState getState()
    {
        return new SwerveModuleState(driveEncoder.getVelocity(), new Rotation2d(turnEncoder.getPosition()));
    }

    public void setDesiredState(SwerveModuleState state)
    {
        if (Math.abs(state.speedMetersPerSecond / 5) < 0.001) // Physical Max Meters Per Second
        {
            stop();
            return;
        }
        state = SwerveModuleState.optimize(state, getState().angle);
        driveMotor.set(state.speedMetersPerSecond / 5);
        turnMotor.set(turnEncoder.getPosition()); //TBD: Implement PID Controller
    }
}