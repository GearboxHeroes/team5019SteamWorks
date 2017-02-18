package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;
import org.usfirst.frc.team5019.robot.commands.DriveJoystickCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;

/**
 *
 */
public class MecanumDriveSubsystem extends Subsystem {
	// Subsystem devices
	private RobotDrive itsRobotDrive;
	private ADXRS450_Gyro itsGyro;
	
	public MecanumDriveSubsystem() {
		itsRobotDrive = new RobotDrive(
				new CANTalon(RobotMap.kLeftFrontDriveMotorCANID),
				new CANTalon(RobotMap.kRightFrontDriveMotorCANID),
				new CANTalon(RobotMap.kLeftRearDriveMotorCANID),
				new CANTalon(RobotMap.kRightRearDriveMotorCANID) );
		
		itsRobotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		itsRobotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		
		itsGyro = new ADXRS450_Gyro();

	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveJoystickCommand());
    }

	public void mecanumDrive(Joystick itsJoystick) {
		// itsRobotDrive.mecanumDrive_Cartesian(
		// 		itsJoystick.getX(),
		// 		itsJoystick.getY(),
		// 		itsJoystick.getZ(),
		// 		0);
		
		itsRobotDrive.mecanumDrive_Cartesian(
				itsJoystick.getRawAxis(1),
				itsJoystick.getRawAxis(0),
				itsJoystick.getRawAxis(4),
				itsGyro.getAngle());
		
		// itsRobotDrive.mecanumDrive_Cartesian(
		// 		itsJoystick.getX(),
		// 		itsJoystick.getY(),
		// 		itsJoystick.getZ(),
		// 		itsGyro.getAngle());		
	}

	public void mecanumDrive(double pX, double pY, double pRotation) {
		itsRobotDrive.mecanumDrive_Cartesian(
				pX,
				pY,
				pRotation,
				0);
		
		// itsRobotDrive.mecanumDrive_Cartesian(
		// 		itsJoystick.getX(),
		// 		itsJoystick.getY(),
		// 		itsJoystick.getZ(),
		// 		itsGyro.getAngle());		
	}
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	public ADXRS450_Gyro getItsGyro() {
		return itsGyro;
	}
	
	public RobotDrive getItsRobotdrive() {
		return itsRobotDrive;
	}
	
}

