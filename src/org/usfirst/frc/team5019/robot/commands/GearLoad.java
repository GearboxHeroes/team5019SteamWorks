package org.usfirst.frc.team5019.robot.commands;

import org.usfirst.frc.team5019.robot.Robot;
import org.usfirst.frc.team5019.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearLoad extends Command {

    public GearLoad() {
    	requires(Robot.getItsGearArmSubsystem());
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Encoder Angle: " + Robot.getItsGearArmSubsystem().getItsGearArmEncoder().getDistance());
    	Robot.getItsGearArmSubsystem().getItsGearArmMotor().setSpeed(-0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Encoder Angle: " + Robot.getItsGearArmSubsystem().getItsGearArmEncoder().getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.getItsGearArmSubsystem().getItsGearArmEncoder().getDistance() <=
    			RobotMap.kGearArmLoadAngle){
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Encoder Angle: " + Robot.getItsGearArmSubsystem().getItsGearArmEncoder().getDistance());
    	Robot.getItsGearArmSubsystem().getItsGearArmMotor().setSpeed(-0.1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
