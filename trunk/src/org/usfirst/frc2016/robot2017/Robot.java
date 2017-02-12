// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2016.robot2017;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

import org.usfirst.frc2016.robot2017.commands.AutonomousCommand;
import org.usfirst.frc2016.robot2017.subsystems.*;

//import java.io.IOException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private final double DELAYPERCOUNT = .02;
    private final double CAL_TIME_LIMIT = 4;
    private double calAttemptTimer;
    private boolean calTimerExpired;
    private boolean lastButton11 = false;
    
/*
 * 	Motors
 * 		Drive train left 2 sparks Drive train
 * 		Drive train rigt 2 sparks
 * 		Climber   1 spark		winch
 * 		Gear Elevator 1 Talon SRX	gear elevator
 * 		Gear Slide linear servo		gear slide
 * 		Gear grabber 1 solenoid		gear grabber
 * 		Drive train shift 1 solenoid
 * 		Compressor????
 * 		Ball Intake 1 spark		ball grabber
 * 		Floor belt  1 spark			floor belt
 * 		transverse belt 1 spark		transverse belt
 * 		low goal shooter 1 spark	low goal shooter
 * 		High goal elevator 1 spark	high goal elevator
 * 		High goal shooter 1 talon SRX    high goal shooter
 * 
 * 		25 inch side battery left front - 8 for battery
 * 		23.5 - 6.6 for height
 */
    /*
     * Labels for auto defenses 
     */
    final String highGoalAuto = "High Goal Auto";

    /*
     * What autonomous command to run
     * and options on the smart dashboard for auto
     */
//    Command autonomousCommand;
    
//    SendableChooser positionChooser;
//    SendableChooser defenseChooser;
    
    /*
     * Flag to indicate that all systems are calibrated and ready
     */
    public static boolean robotIsCalibrated = false;
    
    public static OI oi;
    public PowerDistributionPanel pdPanel;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drivetrain drivetrain;
    public static Gyro gyro;
    public static HighGoalShooter highGoalShooter;
    public static ServoTest servoTest;
    public static Winch winch;
    public static GearElevator gearElevator;
    public static GearSlide gearSlide;
    public static GearGrabber gearGrabber;
    public static FloorBelt floorBelt;
    public static TransBelt transBelt;
    public static LowGoalShooter lowGoalShooter;
    public static HighGoalElevator highGoalElevator;
    public static BallIntake ballIntake;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    RobotPrefs robotPrefs; 
    public int startingPosition;
    Command autonomousCommand; // SHOULD HAVE BEEN AUTOGENERATED
    private CameraServer server;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	//robotIsCalibrated = true; //should be set to false //!!!!!!!!!!!!
    	robotPrefs = new RobotPrefs();
    	calAttemptTimer = 0;
    	calTimerExpired = false;
    	server = CameraServer.getInstance();
    	server.startAutomaticCapture("Front",0);
    	
    	/*
    	 * The following line loads the grip program on the roborio
    	 * comment out the line while debugging the filters on the pc.
    	 */
    	//loadGrip();

        SmartDashboard.putData(Scheduler.getInstance());
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        //gyro = new Gyro();
        highGoalShooter = new HighGoalShooter();
        servoTest = new ServoTest();
        winch = new Winch();
        gearElevator = new GearElevator();
        gearSlide = new GearSlide();
        gearGrabber = new GearGrabber();
        floorBelt = new FloorBelt();
        transBelt = new TransBelt();
        lowGoalShooter = new LowGoalShooter();
        highGoalElevator = new HighGoalElevator();
        ballIntake = new BallIntake();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        pdPanel = new PowerDistributionPanel();
        
        // Set up the position choices
//    	positionChooser = new SendableChooser();
//      positionChooser.addDefault("Position 1", 1);
//    positionChooser.addObject("Position 2", 2);
//        positionChooser.addObject("Position 3", 3);
//        positionChooser.addObject("Position 4", 4);
//        positionChooser.addObject("Position 5", 5);
//        SmartDashboard.putData("Auto position choices", positionChooser);

        // Set up defense choices
//        defenseChooser = new SendableChooser();
        //defenseChooser.addObject("Drawbridge Auto", new AutoDrawbridge());
//        SmartDashboard.putData("Auto defense choices", defenseChooser);
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        robotPrefs.setupPrefs();
        robotPrefs.doLoadPrefs();
//        loadGrip();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
       Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        
//    	startingPosition = (int) positionChooser.getSelected();
    	//SmartDashboard.putNumber("Starting Position", startingPosition);

//        autonomousCommand = (Command) defenseChooser.getSelected();
        // schedule the autonomous command (example)
//    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
//		if (!robotIsCalibrated) {
//			calibrateRobot();
//			if (calTimerExpired) {
//		    	Scheduler.getInstance().run();
//			}
//		}
//		else {
//	    	Scheduler.getInstance().run();
//		}
//        shootElevator.periodic();
//        gyro.periodic();
//        updateDashboard();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running whens
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        if (autonomousCommand != null) autonomousCommand.cancel();
   }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! For testing only
		robotIsCalibrated = true;
		robotPrefs.periodic();
/*    	if (oi.operatorJoy.getRawButton(1)) {
    		robotIsCalibrated = true;
    	}
    	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		robotPrefs.periodic();
		//highGoalShooter.periodic();
		if (!robotIsCalibrated) {
			//calibrateRobot();
			if (calTimerExpired) {
		    	Scheduler.getInstance().run();
			}
		}
		else {
*/
		Scheduler.getInstance().run();
//		}
        gearElevator.periodic();
        gearSlide.periodic();
		//gyro.periodic();
        //highGoalShooter.setup.Periodic();
		updateDashboard();
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    private void loadGrip() {
        /* Run GRIP in a new process */
 //       try {
 //           new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
 //       } catch (IOException e) {
 //           e.printStackTrace();
 //       }    	    
    	}
    
    private void calibrateRobot() {
		if ((calAttemptTimer) <= CAL_TIME_LIMIT/DELAYPERCOUNT) {
			calAttemptTimer ++;
		}
		else {
			calTimerExpired = true;
		}
		if (!gearElevator.isCalibrated()) {
			gearElevator.doCalibrate();
		}
		if (!gearSlide.isCalibrated()) {
			gearSlide.doCalibrate();
		}
		if (gearSlide.isCalibrated() && gearElevator.isCalibrated()) {
			robotIsCalibrated = true;
		}
    }
    
    public boolean isCalibrated() {
    	return robotIsCalibrated;
    }

    private void updateDashboard() {
    	SmartDashboard.putBoolean("Elevator Calibrated", gearElevator.isCalibrated());
   		SmartDashboard.putBoolean("Slide Calibrated", gearSlide.isCalibrated());
    	SmartDashboard.putBoolean("Robot Calibrated",robotIsCalibrated);
    	//SmartDashboard.putNumber("PD Port 4 Current", pdPanel.getCurrent(4));
		SmartDashboard.putNumber("WSpeed",highGoalShooter.speed );
    	}
}
