/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Storm
 */
public class DriveStuff extends CommandGroup {
    public DriveStuff() {
        addSequential(new GyroTurn(90.0, 0.6));
        addSequential(new DoNothing(),0.5);
    }

}
