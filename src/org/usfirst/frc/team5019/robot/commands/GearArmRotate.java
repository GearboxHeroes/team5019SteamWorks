package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;


import edu.wpi.first.wpilibj.command.Command; 

/**
 *
 */
public class GearArmRotate extends Command {
	double aStartAngle;
	double aEndAngle;
	double aCurrentAngle;
	double aAnglePerExecute;
	double aRate;
    public GearArmRotate(double pStartAngle, double pEndAngle) {
    	aStartAngle = pStartAngle;
    	aEndAngle = pEndAngle;
    	aRate = 10; // degrees/second
    	aAnglePerExecute = aRate * 0.020;
    	requires(Robot.getItsGearArmSubsystem());

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	aCurrentAngle = aStartAngle;
    	Robot.getItsGearArmSubsystem().getItsGearArmPid().enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double lDeltaAngle = aEndAngle - aCurrentAngle;
    	
    	if ( lDeltaAngle > aAnglePerExecute) {
    		lDeltaAngle = aAnglePerExecute;
    	}
    	else if ( lDeltaAngle < -aAnglePerExecute) {
    		lDeltaAngle = -aAnglePerExecute;
    	}
    	
    	aCurrentAngle = aCurrentAngle + lDeltaAngle;
    	
    	Robot.getItsGearArmSubsystem().getItsGearArmPid().setSetpoint( aCurrentAngle );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.getItsGearArmSubsystem().getItsGearArmPid().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
