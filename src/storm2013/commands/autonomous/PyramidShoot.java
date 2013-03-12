/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import storm2013.Robot;
import storm2013.commands.DoNothing;
import storm2013.commands.EncoderDrive;
import storm2013.commands.LEDcommands.SetColor;
import storm2013.commands.LowerTilter;
import storm2013.commands.Shoot;
import storm2013.commands.SpinDown;
import storm2013.commands.TargetPIDTilt;
import storm2013.commands.TargetPIDTurn;
import storm2013.subsystems.Vision;
import storm2013.utilities.Target;

/**
 *
 * @author Joe
 */
public class PyramidShoot extends CommandGroup {
    
    public PyramidShoot() {
        addSequential(new Command() {
            {
                requires(Robot.vision);
            }
            protected void initialize() {
                Robot.vision.setDistance(Vision.Distance.CENTER);
                new SetColor(0,0,255).start();
            }
            protected void execute() {}
            protected boolean isFinished() {
                return true;
            }
            protected void end() {}
            protected void interrupted() {}
        });
        addSequential(new Command() {
            {
                requires(Robot.driveTrain);
            }
            protected void initialize() {
                Robot.driveTrain.clearEncoder();
            }
            protected void execute() {
                Robot.driveTrain.tankDrive(-0.6, -0.6);
            }
            protected boolean isFinished() {
                return Robot.driveTrain.getLeftDistance() < -1476;
            }
            protected void end() {
                Robot.driveTrain.tankDrive(0, 0);
            }
            protected void interrupted() {
                end();
            }
        });
        addSequential(new LowerTilter(),1.5);
        addSequential(new TargetPIDTilt(Target.ThreePT, 1.0, false));
//        addParallel(new TargetPIDTurn(Target.ThreePT,1.0,false));
//        addSequential(new WaitForChildren());
        addSequential(new Shoot());
        addSequential(new Shoot());
        addSequential(new Shoot());
        addSequential(new Shoot());
        addSequential(new Shoot());
        addSequential(new Shoot());
        addSequential(new SpinDown());
    }
}