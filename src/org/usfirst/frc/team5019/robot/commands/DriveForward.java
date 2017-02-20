package org.usfirst.frc.team5019.robot.commands;

public class DriveForward extends GenericDriveCommand {
	
    public DriveForward(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kNoX,
    			YDirectionType.kForward,
    			YawDirectionType.kNoYaw);
    }
}
