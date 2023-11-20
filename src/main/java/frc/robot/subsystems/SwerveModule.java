package frc.robot.subsystems;

import frc.robot.components.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

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

        /* initialize motor encoders */
        driveEncoder = driveMotor.getEncoder();
        turnEncoder = turnMotor.getEncoder();

        /* reverse motors */
        driveMotor.setInverted(movement.isReversed);
        turnMotor.setInverted(rotate.isReversed);
    }

    public void stop()
    {
        driveMotor.set(0);
        turnMotor.set(0);
    }
}