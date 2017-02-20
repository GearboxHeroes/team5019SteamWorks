package org.usfirst.frc.team5019.robot.commands;

public class DriveForwardRight extends GenericDriveCommand {
	
    public DriveForwardRight(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kRight,
    			YDirectionType.kForward,
    			YawDirectionType.kNoYaw);
    }
}
