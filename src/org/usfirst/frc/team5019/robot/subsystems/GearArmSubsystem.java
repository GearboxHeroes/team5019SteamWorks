package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearArmSubsystem extends Subsystem {
	protected Spark itsGearArmMotor = new Spark(
			RobotMap.kGearArmMotorID);
	protected Encoder itsGearArmEncoder = new Encoder(
			RobotMap.kGearArmEncoderQuadAID,
			RobotMap.kGearArmEncoderQuadBID);
	
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

