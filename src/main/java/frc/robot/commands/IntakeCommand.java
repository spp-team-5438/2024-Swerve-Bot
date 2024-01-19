package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

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

        if (intakeSubsystem.currentVoltage < Constants.IntakeConstants.maximumIntakeVoltage) {
            intakeSubsystem.intakeMotor.set(Constants.IntakeConstants.maxIntakeSpeed);
            LEDSubsystem.sponsorStrip1.setData(LEDCommand.setStripColor(12, 255, 255, 0)); // add length when get strip
        }
        else {
            intakeSubsystem.stopMotor();
            LEDSubsystem.sponsorStrip1.setData(LEDCommand.setStripColor(12, 245, 114, 7)); // add length when get strip
        } 
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}