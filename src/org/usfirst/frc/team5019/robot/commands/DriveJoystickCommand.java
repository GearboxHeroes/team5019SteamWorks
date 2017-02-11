package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveJoystickCommand extends Command {

    public DriveJoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.getItsMecanumDriveSubsystem());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.getItsMecanumDriveSubsystem().getItsGyro().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.getItsMecanumDriveSubsystem().mecanumDrive(
				Robot.getItsOI().getItsJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.getItsMecanumDriveSubsystem().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
