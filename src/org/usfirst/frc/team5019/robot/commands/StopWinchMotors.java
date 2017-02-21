package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopWinchMotors extends Command {

    public StopWinchMotors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.getItsRopeClimbSubsystem());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.getItsRopeClimbSubsystem().getItsWinchMotor1().set(0.00);
    	Robot.getItsRopeClimbSubsystem().getItsWinchMotor2().set(0.00);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.getItsRopeClimbSubsystem().getItsWinchMotor1().set(0.00);
    	Robot.getItsRopeClimbSubsystem().getItsWinchMotor2().set(0.00);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.getItsRopeClimbSubsystem().getItsWinchMotor1().set(0.0);
    	Robot.getItsRopeClimbSubsystem().getItsWinchMotor2().set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { 
    	end();
    }
}