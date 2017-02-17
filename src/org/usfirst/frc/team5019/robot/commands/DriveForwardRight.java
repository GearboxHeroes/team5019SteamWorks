package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardRight extends Command {

	private int aExecuteNum;
	private int aTimesRun;
	private double aDriveRate;
	private double aSpeedCommand;
	private double bSpeedCommand;
	private int aTimesLeft;
	
    public DriveForwardRight(double pDriveTime) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.getItsMecanumDriveSubsystem());
    	aExecuteNum = (int) (pDriveTime * 50);
    	aTimesRun = 0;
    	aSpeedCommand = 0.0;
    	bSpeedCommand = 0.0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.getItsMecanumDriveSubsystem().getItsGyro().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	aTimesLeft = aExecuteNum - aTimesRun;
    	if (aTimesLeft <= 25) {
    		aSpeedCommand = aSpeedCommand - 0.04;	
    		if(aSpeedCommand <= 0) {
    			aSpeedCommand = 0.0;
    		}
    	} else {
    		aSpeedCommand = aSpeedCommand + 0.04;
    		if (aSpeedCommand >= 1.0) {
    			aSpeedCommand = 1.0;
    	    	}
    	}
    	if (aTimesLeft <= 25) {
    		bSpeedCommand = bSpeedCommand - 0.04;	
    		if(bSpeedCommand <= 0) {
    			bSpeedCommand = 0.0;
    		}
    	} else {
    		bSpeedCommand = bSpeedCommand + 0.04;
    		if (bSpeedCommand >= -1.0) {
    			bSpeedCommand = -1.0;
    	    	}
    	}
    	Robot.getItsMecanumDriveSubsystem().mecanumDrive(aSpeedCommand, bSpeedCommand, 0.0);
    	aTimesRun++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (aTimesRun >= aExecuteNum) {
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
    }
}
