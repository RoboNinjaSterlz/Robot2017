package org.usfirst.frc2016.robot2017;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc2016.robot2017.RobotMap;
import edu.wpi.first.wpilibj.command.*;
import org.usfirst.frc2016.robot2017.Robot;

public class GearInTrigger extends Button {
	public boolean weGrabbed;
	private int activeCount;
	private int solenoidActiveCount;
	
	GearInTrigger() {
	activeCount = 0;
	solenoidActiveCount = 0;
	}


	public boolean get() {
		boolean state;
		// Count so we don't trigger on the first detection
		if (!RobotMap.gearInDetector.get()) {
			activeCount++;
		}
		else {
			activeCount = 0;
		}
		// If this is re-run in auto, make sure the plunger had time to extend before
		// trying again
		if (!Robot.gearGrabber.isGrabbed()) {
			solenoidActiveCount ++;
		}
		else {
			solenoidActiveCount = 0;
		}
		
		/* 
		 * Check where the elevator is
		 * If it isn't in prepare to grab, ignore the switch
		 */
		if (Robot.gearElevator.currentPreset() == 1 &&
				Robot.oi.cCI.getRawButton(1) &&  // Must be in auto mode
				!Robot.gearGrabber.isGrabbed() &&
				solenoidActiveCount > 12) {   // Make sure grabber had time to open 12 should be about.25 seconds.
			// Must be there for 3 counts before we say good.
			return activeCount>2;
		}
		else {
			return false;
		}
	}
}
