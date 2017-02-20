package org.usfirst.frc.team5019.robot.commands;

public class DriveBackwardsRight extends GenericDriveCommand {
	
    public DriveBackwardsRight(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kRight,
    			YDirectionType.kBackward,
    			YawDirectionType.kNoYaw);
    }
}
