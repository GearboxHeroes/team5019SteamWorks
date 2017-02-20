package org.usfirst.frc.team5019.robot.commands;

public class DriveBackwards extends GenericDriveCommand {
	
    public DriveBackwards(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kNoX,
    			YDirectionType.kBackward,
    			YawDirectionType.kNoYaw);
    }
}
