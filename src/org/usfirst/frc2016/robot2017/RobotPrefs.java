/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package edu.wpi.first.wpilibj.templates;

package org.usfirst.frc2016.robot2017;
import org.usfirst.frc2016.robot2017.Defaults;
import org.usfirst.frc2016.robot2017.Robot;

import edu.wpi.first.wpilibj.Preferences;

/**
 *
 * @author Montagna
 */
public class RobotPrefs {
	// This class handles initializing and reading presets from the cRio NV RAM
	Preferences prefs;

	public RobotPrefs() {

	}

	// This is used to see if the operator wants to load new values from
	// the RobRio NVRAM. If so robotPrefs class will perform the operation.
	void periodic() {
		if (Robot.oi.operatorJoy.getRawButton(RobotMap.PREFS_BUTTON)) {
			doLoadPrefs();
		}
	}

	// Read the values stored in NV RAM and store them in variables
	void doLoadPrefs() {
 
		/*
		 * After setting the value, setMax must be called
		 * Unlike the other prefs, drivetrain does not use the limit in every cycle
		 * instead, it is set once by robotbuilder generated code.
		 *  The call to setMax will update the limit.
		 */
		Robot.gearElevator.presetPositions[Robot.gearElevator.LOW] = 
				prefs.getDouble("Elevator "+Robot.gearElevator.ElevatorPositionLabels[Robot.gearElevator.LOW], Defaults.ELEVATORPOSITION1);
		Robot.gearElevator.presetPositions[Robot.gearElevator.HIGH] = 
				prefs.getDouble("Elevator "+Robot.gearElevator.ElevatorPositionLabels[Robot.gearElevator.HIGH], Defaults.ELEVATORPOSITION2);

		Robot.wheelDrive.presetSpeed[0] = 
				prefs.getDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[0], Defaults.WHEEL_SPEED0);
		Robot.wheelDrive.presetSpeed[1] = 
				prefs.getDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[1], Defaults.WHEEL_SPEED1);
/*
 		Robot.wheelDrive.presetSpeed[2] = 
				prefs.getDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[2], Defaults.WHEEL_SPEED2);
		Robot.wheelDrive.presetSpeed[3] = 
				prefs.getDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[3], Defaults.WHEEL_SPEED3);
*/
	}


	// Used to store initial values and create entries in the cRio NVRAM
	void setupPrefs() {
		//Setup the nv RAM in the Roborio
		prefs = Preferences.getInstance();

		if (!prefs.containsKey("Elevator "+Robot.gearElevator.ElevatorPositionLabels[Robot.gearElevator.LOW])) {
			prefs.putDouble("Elevator "+Robot.gearElevator.ElevatorPositionLabels[Robot.gearElevator.LOW], Defaults.ELEVATORPOSITION1);
		}
		if (!prefs.containsKey("Elevator "+Robot.gearElevator.ElevatorPositionLabels[Robot.gearElevator.HIGH]))  {	
			prefs.putDouble("Elevator "+Robot.gearElevator.ElevatorPositionLabels[Robot.gearElevator.HIGH], Defaults.ELEVATORPOSITION2);
		}

		if (!prefs.containsKey("Wheel "+Robot.wheelDrive.WheelSpeedLabels[0])) {
			prefs.putDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[0], Defaults.WHEEL_SPEED0);
		}
		if (!prefs.containsKey("Wheel "+Robot.wheelDrive.WheelSpeedLabels[1])) {
			prefs.putDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[1], Defaults.WHEEL_SPEED1);
		}
/*
		if (!prefs.containsKey("Wheel "+Robot.wheelDrive.WheelSpeedLabels[2])) {
			prefs.putDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[2], Defaults.WHEEL_SPEED2);
		}
		if (!prefs.containsKey("Wheel "+Robot.wheelDrive.WheelSpeedLabels[3])) {
			prefs.putDouble("Wheel "+Robot.wheelDrive.WheelSpeedLabels[3], Defaults.WHEEL_SPEED3);
		}
 */
		
		if (!prefs.containsKey("drivetrainVoltageLimit")) {
			prefs.putDouble("drivetrainVoltageLimit", Defaults.DRIVETRAIN_VOLTAGE_LIMIT_DEFAULT);
		}
	}
}
