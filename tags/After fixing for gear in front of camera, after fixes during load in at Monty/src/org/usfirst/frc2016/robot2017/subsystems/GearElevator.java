// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2016.robot2017.subsystems;

import org.usfirst.frc2016.robot2017.Robot;
import org.usfirst.frc2016.robot2017.RobotMap;
import org.usfirst.frc2016.robot2017.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class GearElevator extends Subsystem {
	
	private boolean didWeMove=true;
	
	public double presetPositions[] = new double[4];
	// Desired encoder count for positioning the gearElevatorTaloner.
	private double desiredPosition = 0;

	// keeps track of when the gearElevatorTalon is calibrated
	private boolean needsCalibrate;
	private int lastPreset;
	// How good does the position need to be
	private final double AbsoluteTolerance = 3;
	
	// Labels for presets in robot prefs on dashboard
	public final String[] ElevatorPositionLabels = { 
		"Low",
		"PrePickup",
		"Medium",
		"High"
	};
	
	public final int
		LOW = 0,
		PREPICKUP =1,
		MEDIUM = 2,
		HIGH = 3;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon gearElevatorTalon = RobotMap.gearElevatorGearElevatorTalon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public GearElevator() {
    	presetPositions[MEDIUM]=1500;
    	needsCalibrate = true;

    	gearElevatorTalon.setProfile(0);
    	gearElevatorTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	gearElevatorTalon.reverseSensor(true);
    	gearElevatorTalon.reverseOutput(false);
    	gearElevatorTalon.setAllowableClosedLoopErr(0);
    	// Keep off until we are calibrated.
    	// Hard limits should protect everything.
    	gearElevatorTalon.enableForwardSoftLimit(false);
    	gearElevatorTalon.enableReverseSoftLimit(false);
    	gearElevatorTalon.clearStickyFaults();
    	gearElevatorTalon.ClearIaccum();
    	//gearElevatorTalon.setVoltageRampRate(6.0);
    	//gearElevatorTalon.setCloseLoopRampRate(.);
    	//gearElevatorTalon.configMaxOutputVoltage(12);
    	// Needed for calibrate
    	gearElevatorTalon.changeControlMode(TalonControlMode.PercentVbus);	
    }

    public void startCalibrate() {
    	gearElevatorTalon.changeControlMode(TalonControlMode.PercentVbus);	
    	needsCalibrate = true;
    }
    // Put methods for controlling this subsystem
        // here. Call these from Commands.
    public void completeCalibration(){
		gearElevatorTalon.set(0); // Turn off output
		desiredPosition = 0;
		gearElevatorTalon.setPosition(0);
		gearElevatorTalon.changeControlMode(TalonControlMode.Position);
		// reset the encoder
		gearElevatorTalon.set(0);
//		gearElevatorTalon.reverseSensor(false);
//		gearElevatorTalon.reverseOutput(true);
		gearElevatorTalon.enable();
		needsCalibrate = false;
    }
    
    public void doCalibrate() {
    	// Zero out the encoder by running the elevator backwards
    	// until they reach the optical sensor on the back of the elevator
    	if (gearElevatorTalon.isRevLimitSwitchClosed()) {
    		completeCalibration();
    	} else {
    		needsCalibrate = true;
    		gearElevatorTalon.set(-.75); // Run back at 45% power
    	}
    }

    	// Returns true if the GearElevator is in the home position
    	public boolean isElevatorAtHome() {
        	return (gearElevatorTalon.isFwdLimitSwitchClosed());
        }

    	// Goes to the encoder count that is passed
        public void goTo(double height) {
    		desiredPosition = height;
    		if (Robot.robotIsCalibrated) {
    			gearElevatorTalon.set(height);
    		}
    		//gearElevatorTalon.enableControl();
        	}
        public void goToPreset(int position) {
        	
        	didWeMove = false;
        	if ((position >= 0) && (position <= presetPositions.length - 1)) {
        		if (Math.abs(presetPositions[position] - desiredPosition) > AbsoluteTolerance ) {
        			didWeMove=true;
        		}
        		goTo(presetPositions[position]);
        		lastPreset=position;
          	}
        }
    	public void incrementHeight() {
    		desiredPosition++;
    		goTo(desiredPosition);
    	}
    	
    	public void decrementHeight() {
    		desiredPosition--;
    		goTo(desiredPosition);
    	}
    	
    	public void adjustHeight( double adjust) {
    		desiredPosition+=adjust;
    		if (desiredPosition < 0) {
    			desiredPosition = 0;
    		}
    		goTo(desiredPosition);
    	}	
    	
    	// Returns true of the gearElevatorTalon is at the desired position (done moving)
    	public boolean isPositioned() {
    		double position;
    		position = Math.abs(desiredPosition - getPosition());
    		if (desiredPosition == 0 && gearElevatorTalon.isRevLimitSwitchClosed()) {
        		gearElevatorTalon.setPosition(0);
    		}
    		return (position <= AbsoluteTolerance);
/*    		position = gearElevatorTalon.getClosedLoopError();
    		return (AbsoluteTolerance >= Math.abs(position));
*/
    		}
    	
    	// Returns the current postion error
    	public int getPositionError() {
    		return gearElevatorTalon.getClosedLoopError();
    	}

    	// Returns the current position
    	public int getPosition() {
    		return (int) gearElevatorTalon.getPosition();
    	}
    	
    	public boolean GearElevatorMoved() {
    		return (didWeMove);
    	}
    	
    	// Returns true if the gearElevatorTalon has been calibrated
    	public boolean isCalibrated(){
    		return !needsCalibrate;
    	}
    	
    	// Return the position by number
    	public int currentPreset() {
    		if (isPositioned()) {
    			return lastPreset;
    		}
    		else {
    			return -1;
    		}
    	}
    	
    	public boolean haveTheGear() {
    		if (getPosition() >= presetPositions[PREPICKUP]-25) {
    			return(!RobotMap.didWeGrab.get());
    		}
    		else {
    			return false;
    		}
    	}
     
    	// mostly for debugging updates the smart dashboard with position info
    	public void periodic() {
    		SmartDashboard.putNumber("GearElevatorTalon Desired Pos", gearElevatorTalon.getSetpoint());
    		SmartDashboard.putNumber("GearElevator Position", getPosition());
    		SmartDashboard.putNumber("GearElevator Position Error", getPositionError());
    		SmartDashboard.putBoolean("Elevator is Positioned", isPositioned());
    		//SmartDashboard.putBoolean("Did Move",shooterMoved());
//    		SmartDashboard.putBoolean("limit sensor", shooterLowerLimit.get());
    		if (lastPreset == HIGH) {
    			double joyY = Robot.oi.operatorJoy.getY();
    		
        	if (Math.abs(joyY) <.05) {
        		joyY = 0;
        	}
        	double position = presetPositions[HIGH]+joyY*1620/13;
        	goTo(position);
    	}
    	}
    	public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
