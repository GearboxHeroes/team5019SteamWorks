package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GenericDriveCommand extends Command {

	public enum XDirectionType {
		kLeft(-1),
		kNoX(0),
		kRight(1);
	
		@SuppressWarnings("MemberName")
		public final int value;
	
		private XDirectionType(int value) {
			this.value = value;
		}
	}

	public enum YDirectionType {
		kBackward(-1),
		kNoY(0),
		kForward(1);
	
		@SuppressWarnings("MemberName")
		public final int value;
	
		private YDirectionType(int value) {
			this.value = value;
		}
	}
	
	public enum YawDirectionType {
		kCounterClockwise(-1),
		kNoYaw(0),
		kClockwise(1);
	
		@SuppressWarnings("MemberName")
		public final int value;
	
		private YawDirectionType(int value) {
			this.value = value;
		}
	}

	protected int aExecuteNum;
	protected int aTimesRun;
	protected double aSpeedCommand;
	protected int aTimesLeft;
	protected double aMaxSpeed;
	protected int aXDirection;
	protected int aYDirection;
	protected int aYawDirection;
	protected int aRampDownWhenCyclesRemaining;
	
    public GenericDriveCommand(double pDriveTime, double pMaxSpeed, XDirectionType pXDirection, YDirectionType pYDirection, YawDirectionType pYawDirection) {
    	aMaxSpeed = pMaxSpeed;
    	aXDirection = pXDirection.value;
    	aYDirection = pYDirection.value;
    	aYawDirection = pYawDirection.value;
    	
    	// 20 millisecond execution rate assumed.
    	// Desired ramp up / ramp down rate is 0.5 seconds to max value.
    	// Will take less time if max speed is less than 1.0.
    	int lCyclesToRamp = (int) (25*aMaxSpeed + 0.5);
    	aExecuteNum = (int) (pDriveTime*50 + 0.5);
    	aRampDownWhenCyclesRemaining = aExecuteNum / 2;
    	if ( aRampDownWhenCyclesRemaining > lCyclesToRamp) {
    		aRampDownWhenCyclesRemaining = lCyclesToRamp;
    	}

    	requires(Robot.getItsMecanumDriveSubsystem());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	aSpeedCommand = 0.0;
    	aTimesRun = 0;
    	aTimesLeft = aExecuteNum;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	aTimesLeft = aExecuteNum - aTimesRun;
    	
    	if (aTimesLeft <= aRampDownWhenCyclesRemaining)
    	{
    		aSpeedCommand = aSpeedCommand - 0.04;
    		
    		if (aSpeedCommand <= 0.0) {
    			aSpeedCommand = 0.0;
    		}
    	}
    	else
    	{
    		aSpeedCommand = aSpeedCommand + 0.04;
    		
    		if (aSpeedCommand >= aMaxSpeed) {
    			aSpeedCommand = aMaxSpeed;
    	    }
    	}

    	Robot.getItsMecanumDriveSubsystem().mecanumDrive(
    			aSpeedCommand * aXDirection,
    			aSpeedCommand * aYDirection,
    			aSpeedCommand * aYawDirection);
    	
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
