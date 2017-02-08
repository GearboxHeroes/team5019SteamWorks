
package org.usfirst.frc.team5019.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5019.robot.commands.DriveJoystickCommand;
import org.usfirst.frc.team5019.robot.commands.ExampleCommand;
import org.usfirst.frc.team5019.robot.subsystems.MecanumDriveSubsystem;
import org.usfirst.frc.team5019.robot.subsystems.GearArmSubsystem;
import org.usfirst.frc.team5019.robot.subsystems.RopeClimbSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	private static final MecanumDriveSubsystem itsMecanumDriveSubsystem = new MecanumDriveSubsystem();
	private static final GearArmSubsystem itsGearArmSubsystem = new GearArmSubsystem();
	private static final RopeClimbSubsystem itsRopeClimbSubsystem = new RopeClimbSubsystem();
	private static OI itsOI;

	Command itsAutonomousCommand;
	Command itsFirstTeleopCommand;
	SendableChooser<Command> itsModeChooser = new SendableChooser<Command>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		itsOI = new OI();
		itsModeChooser.addDefault("Default Auto", new ExampleCommand());
		itsModeChooser.addObject("Left", new ExampleCommand());
		itsModeChooser.addObject("Center", new ExampleCommand());
		itsModeChooser.addObject("Right", new ExampleCommand());
		SmartDashboard.putData("Autonomous mode chooser", itsModeChooser);
		
		itsFirstTeleopCommand = new DriveJoystickCommand();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		itsAutonomousCommand = itsModeChooser.getSelected();

		// schedule the autonomous command (example)
		if (itsAutonomousCommand != null)
			itsAutonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (itsAutonomousCommand != null) {
			itsAutonomousCommand.cancel();
		}
		
		if (itsFirstTeleopCommand != null) {
			Scheduler.getInstance().add(itsFirstTeleopCommand);
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// Watchdog.getInstance().feed(); // pet the dog
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static MecanumDriveSubsystem getItsMecanumDriveSubsystem() {
		return itsMecanumDriveSubsystem;
	}
	
	public static GearArmSubsystem getItsGearArmSubsystem() {
		return itsGearArmSubsystem;
	}
	
	public static RopeClimbSubsystem getItsRopeClimbSubsystem() {
		return itsRopeClimbSubsystem;
	}
	
	public static OI getItsOI() {
		return itsOI;
	}
}
