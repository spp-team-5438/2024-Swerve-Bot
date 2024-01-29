package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Limelight;

public class AlignWithSpeaker extends Command {
    Limelight ll;
    boolean aligned;
    Translation2d zero;
    Swerve swerve;
    double rotSpeed;
    double tolerance;
    double offsetTagOffset;
    PIDController rotationPID;

    public AlignWithSpeaker(Limelight _limelight, Swerve _swerve) {
        ll = _limelight;
        swerve = _swerve;
        tolerance = 0.25;
        zero = new Translation2d(0, 0);
        rotationPID = new PIDController(0.35, 0.0, 0.01);
    }

    @Override
    public void initialize() {
        aligned = false;
    }

    @Override
    public void execute() {
        System.out.println(Math.abs(ll.tx + (ll.tid == 4 ? 13.3 : 0)));
        if(Math.abs(ll.tx + (ll.tid == 4 ? 13.3 : 0)) < tolerance) {
            aligned = true;
        }
        rotSpeed = rotationPID.calculate(ll.tx + (ll.tid == 4 ? 13.3 : 0), 0.0) / 6;
        swerve.drive(zero, rotSpeed, false, true);
    }

    @Override
    public boolean isFinished() {
        return aligned; 
    }
}
