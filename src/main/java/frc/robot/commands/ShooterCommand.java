package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ShooterCommand extends CommandBase {
    private ShooterSubsystem shooter;
    private double speed;

    public ShooterCommand(ShooterSubsystem shooter, double speed)
    {
        this.shooter = shooter;
        this.speed = speed;
    }

    @Override
    public void execute()
    {
        shooter.motorL.set(speed);
        shooter.motorR.set(speed);
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
