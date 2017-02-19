package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;
import org.usfirst.frc.team5019.robot.commands.GearUnload;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearArmSubsystem extends Subsystem {
	protected Spark itsGearArmMotor;
	protected Encoder itsGearArmEncoder;

	public GearArmSubsystem() {
		super("GearArmSubsystem");
		
		itsGearArmMotor = new Spark(RobotMap.kGearArmMotorID);
		itsGearArmMotor.setSafetyEnabled(true);
		itsGearArmMotor.setExpiration(0.1);
		
		itsGearArmEncoder = new Encoder(
			RobotMap.kGearArmEncoderQuadAID,
			RobotMap.kGearArmEncoderQuadBID,
			false,
			Encoder.EncodingType.k2X);
		itsGearArmEncoder.setDistancePerPulse(0.724346);
		itsGearArmEncoder.setSamplesToAverage(4);
		itsGearArmEncoder.reset();
		
		// SmartDashboard.putData("GearArmEncoder",itsGearArmEncoder);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GearUnload());
    }
    
    public Spark getItsGearArmMotor() {
    	return itsGearArmMotor;
    }
    
    public Encoder getItsGearArmEncoder() {
    	return itsGearArmEncoder;
    }
 
}