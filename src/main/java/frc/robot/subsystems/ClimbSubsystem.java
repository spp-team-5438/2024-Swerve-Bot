package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants;

public class ClimbSubsystem
{
    private CANSparkMax climbMotorLeft = new CANSparkMax(Constants.ClimbConstants.climbMotorLeftID, MotorType.kBrushless);
    //private CANSparkMax climbMotorRight = new CANSparkMax(Constants.ClimbConstants.climbMotorRightID, MotorType.kBrushless);

    // This will be called by triggers on the operator controller
    public void setClimbMotors(double desiredSpeed)
    {
        climbMotorLeft.set(desiredSpeed);
        //climbMotorRight.set(desiredSpeed);
    }


}