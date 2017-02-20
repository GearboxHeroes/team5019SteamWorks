package org.usfirst.frc.team5019.robot.commands;

public class DriveClockwise extends GenericDriveCommand {
	
    public DriveClockwise(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kNoX,
    			YDirectionType.kNoY,
    			YawDirectionType.kClockwise);
    }
}
