package org.usfirst.frc2016.robot2017;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc2016.robot2017.RobotMap;;

public class GearInTrigger extends Button {
	
	GearInTrigger() {
	}

	public boolean get() {
    	boolean state;
 
    	state = RobotMap.gearInDetector.get();
		
	return state;
	}
}
