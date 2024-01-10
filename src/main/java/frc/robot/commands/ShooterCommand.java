package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ShooterCommand extends CommandBase {
    public static void shoot(ShooterSubsystem shooterSubsystem, double speed) {
        shooterSubsystem.motorL.set(speed);
        shooterSubsystem.motorR.set(speed);
    }
}
