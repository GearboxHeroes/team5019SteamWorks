package org.usfirst.frc.team5019.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Talon SRX CAN IDs
	public static int kLeftFrontDriveMotorCANID = 1;
	public static int kRightFrontDriveMotorCANID = 2;
	public static int kLeftRearDriveMotorCANID = 3;
	public static int kRightRearDriveMotorCANID = 4;
	public static int kLeftRollerMotorCANID = 5;
	public static int kRightRollerMotorCANID = 6;
	
	// PCM CAN ID
	public static int kPCMCANID = 1;
	
	// Solenoid IDs (map to solenoid port numbers on PCM)
	public static int kThreeWayValvePortID = 0;
	
	// PWM IDs
	public static int kGearArmMotorID = 0;
	
	// Digital I/O Port Numbers
	public static int kGearArmEncoderQuadAID = 0;
	public static int kGearArmEncoderQuadBID = 1;

	// Analog I/O IDs
	public static int kGyroPort = 0;
	
	// Joystick Axes
	public static int kJoystickLX = 0;
	public static int kJoystickLY = 1;
	public static int kJoystickLTrigger = 2;
	public static int kJoystickRTrigger = 3;
	public static int kJoystickRX = 4;
	public static int kJoystickRY = 5;

}

