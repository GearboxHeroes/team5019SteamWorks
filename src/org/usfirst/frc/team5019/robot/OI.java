package org.usfirst.frc.team5019.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	protected Joystick itsJoystick = new Joystick(0);

	public OI() {
		// new JoystickButton(itsJoystick, 12).whenPressed(new LowGoal());
		// new JoystickButton(itsJoystick, 10).whenPressed(new Collect());

		// new JoystickButton(itsJoystick, 11).whenPressed(new SetPivotSetpoint(Pivot.kShoot));
		// new JoystickButton(itsJoystick, 9).whenPressed(new SetPivotSetpoint(Pivot.kShootNear));

		// new DoubleButton(itsJoystick, 2, 3).whenActive(new Shoot());

		// SmartDashboard Buttons
		// SmartDashboard.putData("Drive Forward", new DriveForward(2.25));
		// SmartDashboard.putData("Drive Backward", new DriveForward(-2.25));
		// SmartDashboard.putData("Start Rollers", new SetCollectionSpeed(Collector.kForward));
		// SmartDashboard.putData("Stop Rollers", new SetCollectionSpeed(Collector.kStop));
		// SmartDashboard.putData("Reverse Rollers", new SetCollectionSpeed(Collector.kReverse));
	}

	public Joystick getItsJoystick() {
		return itsJoystick;
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
