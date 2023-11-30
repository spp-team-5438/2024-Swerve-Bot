package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilib.*;
import edu.wpi.first.wpilib2.*;

public class SolenoidSubsystem {
    public PneumaticHub RoboComp = new PneumaticHub(PneumaticConstants.pneumaticPort);
    public static DoubleSolenoid Solenoid = new DoubleSolenoid(10, PneumaticsModuleType.REVPH, 1, 2);

    public SolenoidSubsystem {
        Solenoid.set(Value.kOff);
        Solenoid.set(Value.kReverse);    
        RoboComp.enableCompressorAnalog(PneumaticConstants.lowerLimit, PneumaticConstants.upperLimit);
    }
}