package org.usfirst.frc.team5019.robot.commands;

public class DriveBackwardsLeft extends GenericDriveCommand {
	
    public DriveBackwardsLeft(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kLeft,
    			YDirectionType.kBackward,
    			YawDirectionType.kNoYaw);
    }
}
