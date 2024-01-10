package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public final class IntakeCommand extends CommandBase {
    public static void driveIntake(IntakeSubsystem s_Intake) {
        s_Intake.intakeMotor.set(Constants.intakeMotorSpeed);
    }
}