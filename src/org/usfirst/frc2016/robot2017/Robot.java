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

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc2016.robot2017.commands.AutonomousCommand;
import org.usfirst.frc2016.robot2017.subsystems.*;
import org.usfirst.frc2016.robot2017.commands.*;

//import java.io.IOException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private final String GEARALIGNMENT = "GearAlignment";
	private final String FLASHLEDS = "FlashLEDs";
	private final String RECORDVIDEO = "RecordVideo";
	private final String IDLE = "Idle";
	private  String PIMode = "comeback2later";
	private final double DELAYPERCOUNT = .02;
	private final double CAL_TIME_LIMIT = 4;
	private double calAttemptTimer;
	private boolean calTimerExpired;
	private CameraServer camServer;
	public static UsbCamera frontCamera;
	public static UsbCamera rearCamera;
	public static VideoSink server;
	public static boolean frontCameraActive=true;

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
	 * Labels for auto routines 
	 */
	final String straightGearAuto = "Straight Gear";
	final String driveForward = "Drive Forward";
	final String gearRightSide = "Right Side Gear";
	final String gearLeftSide = "Left Side Gear";
	final String straightGearAndBaseline = "straightGearAndBaseline";
	/*
	 * What autonomous command to run
	 * and options on the smart dashboard for auto
	 */
	//    Command autonomousCommand;

	SendableChooser autoChooser;

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
    public static GearSlide gearSlide;
    public static Winch winch;
    public static GearElevator gearElevator;
    public static GearGrabber gearGrabber;
    public static FloorBelt floorBelt;
    public static TransBelt transBelt;
    public static LowGoalShooter lowGoalShooter;
    public static HighGoalElevator highGoalElevator;
    public static BallIntake ballIntake;
    public static Cameras cameras;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static RobotPrefs robotPrefs; 
	public int startingPosition;
	Command autonomousCommand; // SHOULD HAVE BEEN AUTOGENERATED
	//    private CameraServer server;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		robotIsCalibrated = false;
		robotPrefs = new RobotPrefs();
		calAttemptTimer = 0;
		calTimerExpired = false;

		camServer = CameraServer.getInstance();
		frontCamera=camServer.startAutomaticCapture("Switcher", 0);
		// 0 being the port of the camera
/*		frontCamera = new UsbCamera("Front",0);
		//        rearCamera = new UsbCamera("Rear", 1);
		camServer.addCamera(frontCamera);
		//        camServer.addCamera(rearCamera);
		server = camServer.addServer("serve_Switcher");
		server.setSource(frontCamera);
		frontCameraActive=true;
*/
		/*
		 * The following line loads the grip program on the roborio
		 * comment out the line while debugging the filters on the pc.
		 */
		//loadGrip();

		SmartDashboard.putData(Scheduler.getInstance());

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        gyro = new Gyro();
        highGoalShooter = new HighGoalShooter();
        gearSlide = new GearSlide();
        winch = new Winch();
        gearElevator = new GearElevator();
        gearGrabber = new GearGrabber();
        floorBelt = new FloorBelt();
        transBelt = new TransBelt();
        lowGoalShooter = new LowGoalShooter();
        highGoalElevator = new HighGoalElevator();
        ballIntake = new BallIntake();
        cameras = new Cameras();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		//(which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		robotPrefs.setupPrefs();
		robotPrefs.doLoadPrefs();
		oi = new OI();
		pdPanel = new PowerDistributionPanel();
		Scheduler.getInstance().add(new CalibrateElevator());

		// Set up the position choices
		autoChooser = new SendableChooser();
		autoChooser.addDefault(driveForward, new AutoCrossBaseline());
		autoChooser.addObject(straightGearAuto, new AutoStraightGearPlacement());
		autoChooser.addObject(gearRightSide, new AutoGearRightSide());
		autoChooser.addObject(gearLeftSide, new AutoLeftGearPlacement());
		autoChooser.addObject(straightGearAndBaseline, new AutoStraightGearBaseline());
		SmartDashboard.putData("Autonomous choices", autoChooser);

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
		//        loadGrip();
//		Scheduler.getInstance().add(new CenterSlide());
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		PIMode = IDLE;
		//updateDashboard();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		if (!robotIsCalibrated) {
			calibrateRobot();
		}
		Scheduler.getInstance().run();
		gearElevator.periodic();
		gyro.periodic();
		PIMode = RECORDVIDEO;
		updateDashboard();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running whens
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		robotPrefs.periodic();
		if (!robotIsCalibrated) {
			calibrateRobot();
		}
		Scheduler.getInstance().run();
		gearElevator.periodic();
		gyro.periodic();
		PIMode = RECORDVIDEO;
		updateDashboard();
	}
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	/*
    private void loadGrip() {
        // Run GRIP in a new process
       try {
           new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
       } catch (IOException e) {
           e.printStackTrace();
       }    	    
 	}
	 */    
	public void calibrateRobot() {
		if ((calAttemptTimer) <= CAL_TIME_LIMIT/DELAYPERCOUNT) {
			calAttemptTimer ++;
		}
		else {
			calTimerExpired = true;
		}
		if (gearElevator.isCalibrated()) {
			robotIsCalibrated = true;
		}
	}

	public boolean isCalibrated() {
		return robotIsCalibrated;
	}

	private void updateDashboard() {
		SmartDashboard.putBoolean("Elevator Calibrated", gearElevator.isCalibrated());
		SmartDashboard.putBoolean("Robot Calibrated",robotIsCalibrated);
		//SmartDashboard.putNumber("PD Port 4 Current", pdPanel.getCurrent(4));
		//SmartDashboard.putNumber("WSpeed",highGoalShooter.speed );
		SmartDashboard.putNumber("GearSlidePosition", gearSlide.desiredPosition);
		SmartDashboard.putNumber("LeftEncoder", RobotMap.drivetrainLeftEncoder.getDistance());
		SmartDashboard.putNumber("LeftEncoderRaw", RobotMap.drivetrainLeftEncoder.get());
		SmartDashboard.putNumber("RightEncoder", RobotMap.drivetrainRightEncoder.getDistance());
		SmartDashboard.putNumber("RightEncoderRaw", RobotMap.drivetrainRightEncoder.get());
		SmartDashboard.putString("PIMode", PIMode);
		SmartDashboard.putBoolean("GearTrigger", oi.gearTrigger.get());
		SmartDashboard.putBoolean("WeGrabbedTheGear", gearElevator.haveTheGear());
		SmartDashboard.putBoolean("AutoSwitch", Robot.oi.cCI.getRawButton(1));
	}
}

