package frc.robot.components;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Motor {
    public int id;
    public MotorType type;
    public boolean isReversed;  
    
    public Motor(int Id, MotorType motorType, boolean reversed)
    {
        id = Id;
        type = motorType;
        isReversed = reversed;
    }
}