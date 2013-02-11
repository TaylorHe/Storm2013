package storm2013.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import storm2013.RobotMap;

/**
 *
 * @author Joe
 */
public class Tomahawk extends Subsystem {
    private static double MOTOR_SPEED = 1;
    
    private Victor _motor;
    private DigitalInput _limitSwitch;
    
    public Tomahawk() {
        _motor = new Victor(RobotMap.PORT_MOTOR_TOMAHAWK);
        _limitSwitch = new DigitalInput(RobotMap.PORT_LIMIT_TOMAHAWK);
    }

    public void initDefaultCommand() {}
    
    public boolean isForward() {
        return _limitSwitch.get();
    }
    
    public void move() {
//        if(Robot.shooter.isEnabled()) {
            _motor.set(MOTOR_SPEED);
//        }
    }
    public void stop() {
        _motor.set(0);
    }
}