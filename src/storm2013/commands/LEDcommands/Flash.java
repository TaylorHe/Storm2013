/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.commands.LEDcommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import storm2013.Robot;

/**
 *
 * @author evan1026
 */
public class Flash extends Command {
    
    public static final double DEFAULT_PERIOD = 1; //once a second
    
    private Timer _timer = new Timer();
    private Color[] _colors;
    private double  _period;
    private int index;

    public Flash(Color[] colors) {
        this(colors, DEFAULT_PERIOD);
    }
    
    /**
     * 
     * @param colors
     * @param period In seconds
     */
    public Flash(Color[] colors, double period) {
        _colors = colors;
        _period = period;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        
        double time = _timer.get();
        
        if(time >= _period){
            Robot.ledStrip.setColor(_colors[index].getRed(), _colors[index].getGreen(), _colors[index].getBlue());
            index = (index + 1) % _colors.length;
            _timer.reset();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
    
}