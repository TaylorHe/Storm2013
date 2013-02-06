/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storm2013.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;
import storm2013.Robot;
import storm2013.RobotMap;
import storm2013.subsystems.DriveTrain;

/**
 *
 * @author evan1026
 */
public class GyroTurn extends Command {

    private double _goal;
    private double _dist;
    private double _turnSpeed;
    private double _tolerance;
    
    private DriveTrain _driveTrain = Robot.driveTrain;
    
    public GyroTurn(double goal, double turnSpeed, double tolerance){
        _goal = goal;
        _turnSpeed = turnSpeed;
        _tolerance = tolerance;
        requires(Robot.driveTrain);
    }
    
    protected void initialize() {
        Robot.driveTrain.clearGyro();
    }

    protected void execute() {
        _dist = Robot.driveTrain.getGyroAngle();
        
	if (_dist < _goal){
	    _driveTrain.tankDrive(-_turnSpeed, _turnSpeed);
	}
	else if (_dist > _goal){
	    _driveTrain.tankDrive(_turnSpeed, -_turnSpeed);
	}
    }

    protected boolean isFinished() {
        if(_goal < 0) {
	    return _dist - _tolerance <= _goal;
	} else {
	    return _dist + _tolerance >= _goal;
	}
    }

    protected void end() {
	Robot.driveTrain.tankDrive(0, 0);
    }

    protected void interrupted() {
        end();
    }
    
    public double getGoal() {
        return _goal;
    }
    
    public void setGoal(double goal) {
        _goal = goal;
    }

    public double getDist() {
        return _dist;
    }
   
    public double getDriveSpeed() {
        return _turnSpeed;
    }
    
    public void setTurnSpeed(double driveSpeed) {
        _turnSpeed = driveSpeed;
    }
    
    public double getTolerance() {
        return _tolerance;
    }
    
    public void setTolerance(double tolerance) {
        _tolerance = tolerance;
    }
    
}
