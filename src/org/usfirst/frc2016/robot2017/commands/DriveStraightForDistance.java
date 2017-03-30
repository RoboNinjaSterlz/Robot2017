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

import org.usfirst.frc2016.robot2017.Robot;

/**
 *
 */
public class DriveStraightForDistance extends Command {

	private double startingAngle;
	private double lEncoderStart, rEncoderStart;
	private int waitCounter;
	private final double DELAYPERCOUNT = .02;
	private final int TIMEOUT=3;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_speed;
    private double m_distance;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveStraightForDistance(double speed, double distance) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    	m_speed = speed;
    	m_distance = distance;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lEncoderStart = Robot.drivetrain.getLeftEncoder();
    	rEncoderStart = Robot.drivetrain.getRightEncoder();
    	startingAngle = Robot.gyro.getAngle();
    	waitCounter = 0;
    	//Robot.gyro.reset();
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.drivetrain.arcadeDrive(Robot.oi.driveRight.getY(), 0);
    	waitCounter++;
    	Robot.drivetrain.gyroDrive(m_speed, startingAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean done = false;
    	done = (m_distance <= Math.abs((Robot.drivetrain.getRightEncoder() - rEncoderStart)));
    	if (!done) {
    		done = (waitCounter >= (int)(TIMEOUT/DELAYPERCOUNT));
    	}
    	return(done);
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
