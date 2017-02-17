package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;


import edu.wpi.first.wpilibj.command.Command; 

/**
 *
 */
public class GearArmRotate extends Command {
	private double aStartAngle;
	private double aEndAngle;
	private double aCurrentAngle;
	private double aAnglePerExecute;
	private double aRate;
    public GearArmRotate(double pEndAngle) {
    	requires(Robot.getItsGearArmSubsystem());
    	aEndAngle = pEndAngle;
    	aRate = 10.0; // degrees/second
    	aAnglePerExecute = aRate * 0.020;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	aStartAngle = Robot.getItsGearArmSubsystem().getItsGearArmEncoder().getDistance();
    	aCurrentAngle = aStartAngle;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double lDeltaAngle = aEndAngle - aCurrentAngle;
    	
    	if (lDeltaAngle > aAnglePerExecute) {
    		lDeltaAngle = aAnglePerExecute;
    	}
    	else if (lDeltaAngle < -aAnglePerExecute) {
    		lDeltaAngle = -aAnglePerExecute;
    	}
    	
    	aCurrentAngle = aCurrentAngle + lDeltaAngle;
    	
    	// Robot.getItsGearArmSubsystem().getItsGearArmMotor().set(1.0);
    	Robot.getItsGearArmSubsystem().getItsGearArmPid().setSetpoint( aCurrentAngle );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (aCurrentAngle == aEndAngle) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
