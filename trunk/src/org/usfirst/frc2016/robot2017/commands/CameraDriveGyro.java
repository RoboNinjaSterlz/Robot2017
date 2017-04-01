// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2016.robot2017.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2016.robot2017.Robot;

/**
 *
 */
public class CameraDriveGyro extends Command {

	private double startingAngle;
	private double targetCorrection;
	private double lastValidTargetCorrection;
	private double targetDistance;
	private int waitCounter;
	private final double DELAYPERCOUNT = .02;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public CameraDriveGyro() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingAngle = Robot.gyro.getAngle();
    	lastValidTargetCorrection = 0;
    	waitCounter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed;
    	//if (waitCounter < 25) {
    		//speed = -.65;
    	//}
    	//else {
    		speed = -.60;
    	//}
    	/*
    	 * Get angle from PI add to starting angle
    	 * Get the driving distance so we know when to stop
    	 */
    	startingAngle = Robot.gyro.getAngle();
    	targetCorrection = SmartDashboard.getNumber("GearAlignAngleError", 1000);
    	if (targetCorrection < 30 && targetCorrection > -30) {
     		lastValidTargetCorrection = targetCorrection;
    	}

   		if ( lastValidTargetCorrection < -20 ) {
   			lastValidTargetCorrection = -20;
   		}
   		else if (lastValidTargetCorrection > 20){
   			lastValidTargetCorrection = 20;
   		}
		Robot.drivetrain.gyroDrive(speed, startingAngle-lastValidTargetCorrection);
		waitCounter++;
   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean returnCode = false;
    	targetDistance = SmartDashboard.getNumber("GearAlignDistance", 1000);
    	//SmartDashboard.putNumber("Distance", targetDistance);
    	if (targetDistance < 10*12) {
    		returnCode = targetDistance < 25;
    	}
        return returnCode; //|| waitCounter*DELAYPERCOUNT > 5;
        }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.driveStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}