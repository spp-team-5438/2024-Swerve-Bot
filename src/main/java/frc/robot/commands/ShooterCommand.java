package frc.robot.commands;
import frc.robot.subsystems.*;

public class ShooterCommand {
    public static void shoot(ShooterSubsystem shooterSubsystem, double speed) {
        shooterSubsystem.motorL.set(speed);
        shooterSubsystem.motorR.set(speed);
    }
}
