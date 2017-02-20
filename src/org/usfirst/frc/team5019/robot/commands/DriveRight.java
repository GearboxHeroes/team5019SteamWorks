package org.usfirst.frc.team5019.robot.commands;

public class DriveRight extends GenericDriveCommand {
	
    public DriveRight(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kRight,
    			YDirectionType.kNoY,
    			YawDirectionType.kNoYaw);
    }
}
