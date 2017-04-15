package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.FRCLoggable;
import org.usfirst.frc.team5019.robot.RobotMap;
import org.usfirst.frc.team5019.robot.commands.StopWinchMotors;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RopeClimbSubsystem extends Subsystem implements FRCLoggable {
	protected CANTalon itsWinchMotor1;
	protected CANTalon itsWinchMotor2;
	
	public RopeClimbSubsystem() {
		super("RopeClimbSubsystem");
		
		itsWinchMotor1 = new CANTalon(RobotMap.kWinchMotor1CANID);
		itsWinchMotor1.setSafetyEnabled(false);
		itsWinchMotor1.setInverted(true);

		itsWinchMotor2 = new CANTalon(RobotMap.kWinchMotor2CANID);
		itsWinchMotor2.setSafetyEnabled(false);
		itsWinchMotor2.setInverted(true);

		// LiveWindow.addActuator("RopeClimbSubsystem", "Winch Motor 1", itsWinchMotor1);
		// LiveWindow.addActuator("RopeClimbSubsystem", "Winch Motor 2", itsWinchMotor2);
	}
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopWinchMotors());
    }
    
	public void climbRope( Joystick itsJoystick )
	{
		itsWinchMotor1.set(itsJoystick.getRawAxis(RobotMap.kJoystickLTrigger));
		itsWinchMotor2.set(itsJoystick.getRawAxis(RobotMap.kJoystickLTrigger));
	}
    
    public CANTalon getItsWinchMotor1() {
    	return itsWinchMotor1;
    }
    
    public CANTalon getItsWinchMotor2() {
    	return itsWinchMotor2;
    }
    
	@Override
	public void log() {
		// SmartDashboard.putNumber("Winch Motor 1 Speed", itsWinchMotor1.getSpeed());
		// SmartDashboard.putNumber("Winch Motor 2 Speed", itsWinchMotor2.getSpeed());
	}

}
