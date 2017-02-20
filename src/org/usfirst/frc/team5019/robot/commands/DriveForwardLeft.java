package org.usfirst.frc.team5019.robot.commands;

public class DriveForwardLeft extends GenericDriveCommand {
	
    public DriveForwardLeft(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kLeft,
    			YDirectionType.kForward,
    			YawDirectionType.kNoYaw);
    }
}
