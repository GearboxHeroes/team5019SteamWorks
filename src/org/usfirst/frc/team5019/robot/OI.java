package org.usfirst.frc.team5019.robot;

import org.usfirst.frc.team5019.robot.commands.GearArmRotate;
import org.usfirst.frc.team5019.robot.commands.OpenSquishers;
import org.usfirst.frc.team5019.robot.commands.PreSpinSquishers;
import org.usfirst.frc.team5019.robot.commands.RunCompressor;
import org.usfirst.frc.team5019.robot.commands.SpinSquishers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	protected Joystick itsJoystick;
	
	public OI() {
		itsJoystick = new Joystick(0);
		new JoystickButton(itsJoystick, 1).toggleWhenPressed(new OpenSquishers());
		new JoystickButton(itsJoystick, 2).whileHeld(new PreSpinSquishers());
		new JoystickButton(itsJoystick, 3).toggleWhenPressed(new SpinSquishers());
		
		new JoystickButton(itsJoystick, 5).whenPressed(new GearArmRotate(-47.0));
		new JoystickButton(itsJoystick, 6).whenPressed(new GearArmRotate(-2.0));
		new JoystickButton(itsJoystick, 7).whenPressed(new RunCompressor());
		
	}

	public Joystick getItsJoystick() {
		return itsJoystick;
	}
	
	// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	//  button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}