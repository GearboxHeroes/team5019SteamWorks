package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearArmSubsystem extends Subsystem {
	protected Spark itsGearArmMotor;
	protected Encoder itsGearArmEncoder;

	public GearArmSubsystem() {
		itsGearArmMotor = new Spark(RobotMap.kGearArmMotorID);
		itsGearArmEncoder = new Encoder(
			RobotMap.kGearArmEncoderQuadAID,
			RobotMap.kGearArmEncoderQuadBID);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Spark getItsGearArmMotor() {
    	return itsGearArmMotor;
    }
    
    public Encoder getItsGearArmEncoder() {
    	return itsGearArmEncoder;
    }
}

