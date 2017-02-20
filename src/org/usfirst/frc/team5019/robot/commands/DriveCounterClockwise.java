package org.usfirst.frc.team5019.robot.commands;

public class DriveCounterClockwise extends GenericDriveCommand {
	
    public DriveCounterClockwise(double pDriveTime, double pMaxSpeed) {
    	super(pDriveTime, pMaxSpeed,
    			XDirectionType.kNoX,
    			YDirectionType.kNoY,
    			YawDirectionType.kCounterClockwise);
    }
}
