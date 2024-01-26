package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Limelight;

public class AlignWithSpeaker extends Command {
    double tolerance;
    Limelight ll;
    boolean aligned;
    Translation2d zero;
    Swerve swerve;
    double rotSpeed;

    public AlignWithSpeaker(Limelight _limelight, Swerve _swerve) {
        ll = _limelight;
        swerve = _swerve;
        aligned = false;
        tolerance = 1;
        rotSpeed = 0.5;
        zero = new Translation2d(0, 0);
    }

    public void initialize() {
        aligned = false;
    }

    public void execute() {
        // Needs to turn 
        // if(ll.tid == 4) {
        //     swerve.drive(zero, -rotSpeed, false, true);
        if(ll.tx < -tolerance) {
            swerve.drive(zero, rotSpeed, false, true);
        } else if(ll.tx > tolerance) {
            swerve.drive(zero, -rotSpeed, false, true);
        } else {
            aligned = true;
        }
    }

    public boolean isFinished() {
        return aligned; 
    }
}
