package org.usfirst.frc.team5019.robot.commands;

public class DriveLeft extends GenericDriveCommand {
	
    public DriveLeft(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kLeft,
    			YDirectionType.kNoY,
    			YawDirectionType.kNoYaw);
    }
}
