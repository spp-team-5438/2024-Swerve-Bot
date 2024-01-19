package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public final class IntakeCommand extends CommandBase {

    private IntakeSubsystem intakeSubsystem;

    public IntakeCommand(IntakeSubsystem intakeSubsystem)
    {
        this.intakeSubsystem = intakeSubsystem;
    }

    @Override
    public void execute()
    {
        intakeSubsystem.currentVoltage = intakeSubsystem.getVoltage();

        if (intakeSubsystem.currentVoltage < Constants.IntakeConstants.maximumIntakeVoltage)
            intakeSubsystem.intakeMotor.set(Constants.IntakeConstants.maxIntakeSpeed);
        else 
            intakeSubsystem.stopMotor();
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}