package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;
import org.usfirst.frc.team5019.robot.commands.DriveJoystickCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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
		super("MecanumDriveSubsystem");
		
		itsRobotDrive = new RobotDrive(
				new CANTalon(RobotMap.kLeftFrontDriveMotorCANID),
				new CANTalon(RobotMap.kLeftRearDriveMotorCANID),
				new CANTalon(RobotMap.kRightFrontDriveMotorCANID),
				new CANTalon(RobotMap.kRightRearDriveMotorCANID) );
		
		itsRobotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		itsRobotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		itsGyro = new ADXRS450_Gyro();
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
				itsJoystick.getRawAxis(0),
				itsJoystick.getRawAxis(1),
				itsJoystick.getRawAxis(4),
				0);
	}

	public void mecanumDrive(double pX, double pY, double pRotation) {
		// need to undo the effect of joystick inversion on the y-axis
		// inside the Robot Drive class, which we can't change.
		itsRobotDrive.mecanumDrive_Cartesian(
				pX,
				-pY,
				pRotation,
				0);	
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

