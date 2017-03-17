package org.usfirst.frc2016.robot2017;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc2016.robot2017.RobotMap;;

public class GearInTrigger extends Button {
	private int activeCount;
	GearInTrigger() {
		activeCount = 0;
	}

	public boolean get() {
		boolean state;

		if (RobotMap.gearInDetector.get()) {
			count++;
		}
		else {
			count = 0;
		}
		/* 
		 * Check where the elevator is
		 * If it isn't in prepare to grab, ignore the switch
		 */
		if (Robot.gearElevator.currentPreset == 1) {
			// Must be there for 3 counts before we say good.
			return count>2;
		}
		else {
			return false;
		}
	}
}
