package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.FRCLoggable;
import org.usfirst.frc.team5019.robot.RobotMap;
import org.usfirst.frc.team5019.robot.commands.DriveJoystickCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;

/**
 *
 */
public class MecanumDriveSubsystem extends Subsystem implements FRCLoggable {
	// Subsystem devices
	private RobotDrive itsRobotDrive;
	// private ADXRS450_Gyro itsGyro;
	private CANTalon itsLeftFrontMotor;
	private CANTalon itsRightFrontMotor;
	private CANTalon itsLeftRearMotor;
	private CANTalon itsRightRearMotor;
	
	public MecanumDriveSubsystem() {
		super("MecanumDriveSubsystem");
		
		itsLeftFrontMotor = new CANTalon(RobotMap.kLeftFrontDriveMotorCANID);
		itsRightFrontMotor = new CANTalon(RobotMap.kRightFrontDriveMotorCANID);
		itsLeftRearMotor = new CANTalon(RobotMap.kLeftRearDriveMotorCANID);
		itsRightRearMotor = new CANTalon(RobotMap.kRightRearDriveMotorCANID);
		
		itsRobotDrive = new RobotDrive(
				itsLeftFrontMotor,
				itsLeftRearMotor,
				itsRightFrontMotor,
				itsRightRearMotor );
		
		itsRobotDrive.setExpiration(0.2);
		
		itsRobotDrive.setInvertedMotor(MotorType.kFrontLeft, false);
		itsRobotDrive.setInvertedMotor(MotorType.kRearLeft, false);
		itsRobotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		itsRobotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		// itsGyro = new ADXRS450_Gyro();
		// itsGyro.reset();
		
		// LiveWindow.addActuator("MecanumDriveSubsystem", "Left Front Motor", itsLeftFrontMotor);
		// LiveWindow.addActuator("MecanumDriveSubsystem", "Right Front Motor", itsRightFrontMotor);
		// LiveWindow.addActuator("MecanumDriveSubsystem", "Left Rear Motor", itsLeftRearMotor);
		// LiveWindow.addActuator("MecanumDriveSubsystem", "Right Rear Motor", itsRightRearMotor);
		// LiveWindow.addSensor("MecanumDriveSubsystem", "Gyro", itsGyro);

	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveJoystickCommand());
    }

	public void mecanumDrive(Joystick itsJoystick) {
		// Y axis flipped inside Robot Drive
		itsRobotDrive.mecanumDrive_Cartesian(
				itsJoystick.getRawAxis(RobotMap.kJoystickLX),
				itsJoystick.getRawAxis(RobotMap.kJoystickLY),
				itsJoystick.getRawAxis(RobotMap.kJoystickRX)*0.5,
				0 );
	}

	public void mecanumDrive(double pX, double pY, double pRotation) {
		// need to undo the effect of joystick inversion on the y-axis
		// inside the Robot Drive class, which we can't change.
		itsRobotDrive.mecanumDrive_Cartesian(
				pX,
				-pY,
				pRotation,
				0 );	
	}
	public void stop() {
	}
	
	// public ADXRS450_Gyro getItsGyro() {
	// 	return itsGyro;
	// }
	
	public RobotDrive getItsRobotdrive() {
		return itsRobotDrive;
	}

	@Override
	public void log() {
		// SmartDashboard.putNumber("Left Front Motor Speed", itsLeftFrontMotor.getSpeed());
		// SmartDashboard.putNumber("Right Front Motor Speed", itsRightFrontMotor.getSpeed());
		// SmartDashboard.putNumber("Left Rear Motor Speed", itsLeftRearMotor.getSpeed());
		// SmartDashboard.putNumber("Right Rear Motor Speed", itsRightRearMotor.getSpeed());
		// SmartDashboard.putNumber("Gyro Angle", itsGyro.getAngle());
		// SmartDashboard.putNumber("Gyro Rate", itsGyro.getRate());
	}
	
}
