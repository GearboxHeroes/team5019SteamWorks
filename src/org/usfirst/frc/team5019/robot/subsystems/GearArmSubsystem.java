package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.PIDController;

/**
 *
 */
public class GearArmSubsystem extends Subsystem {
	protected Spark itsGearArmMotor;
	protected Encoder itsGearArmEncoder;
	protected PIDController itsGearArmPid;

	public GearArmSubsystem() {
		itsGearArmMotor = new Spark(RobotMap.kGearArmMotorID);
		itsGearArmMotor.setSafetyEnabled(true);
		
		itsGearArmEncoder = new Encoder(
			RobotMap.kGearArmEncoderQuadAID,
			RobotMap.kGearArmEncoderQuadBID,
			false,
			Encoder.EncodingType.k2X);
		itsGearArmEncoder.setDistancePerPulse(0.724346);
		itsGearArmEncoder.reset();
		
		itsGearArmPid = new PIDController(
				0.1, 0.0, 0.0, itsGearArmEncoder, itsGearArmMotor, 0.050 ); // 50 ms loop
		itsGearArmPid.setContinuous(false);
		itsGearArmPid.setAbsoluteTolerance(0.5);
		itsGearArmPid.setInputRange(-20.0, 110.0);
		itsGearArmPid.setOutputRange(-1.0, 1.0);
		LiveWindow.addActuator("GearArmSubsytem", "PIDController", itsGearArmPid);
		itsGearArmPid.setSetpoint(0.0);
		itsGearArmPid.enable();
		
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
    
    public PIDController getItsGearArmPid() {
    	return itsGearArmPid;
    }
}