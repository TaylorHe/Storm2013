/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.commands;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import storm2013.RobotMap;

/**
 *
 * @author evan1026
 */
public class StopFeeder extends Command {

    Victor feeder;
    
    public StopFeeder(){
        feeder = new Victor(RobotMap.PORT_MOTOR_FEEDER);
    }
    
    protected void initialize() {
        feeder.set(0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
    
}
