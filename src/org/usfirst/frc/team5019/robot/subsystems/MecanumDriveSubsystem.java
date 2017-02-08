package org.usfirst.frc.team5019.robot.subsystems;

import org.usfirst.frc.team5019.robot.RobotMap;
import org.usfirst.frc.team5019.robot.commands.DriveJoystickCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;

/**
 *
 */
public class MecanumDriveSubsystem extends Subsystem {
	// Subsystem devices
	private RobotDrive itsRobotDrive = new RobotDrive(
			new CANTalon(RobotMap.kLeftFrontDriveMotorCANID),
			new CANTalon(RobotMap.kRightFrontDriveMotorCANID),
			new CANTalon(RobotMap.kLeftRearDriveMotorCANID),
			new CANTalon(RobotMap.kRightRearDriveMotorCANID) );
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveJoystickCommand());
    }

	public void mecanumDrive(Joystick itsJoystick) {
		itsRobotDrive.mecanumDrive_Cartesian(
				itsJoystick.getX(),
				itsJoystick.getY(),
				itsJoystick.getZ(),
				0);		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
}

