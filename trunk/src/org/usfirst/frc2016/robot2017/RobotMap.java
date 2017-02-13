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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Button Defines
	public static final int
    // Button to load prefs
	PREFS_BUTTON = 10;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainLeftdrive;
    public static SpeedController drivetrainRightdrive;
    public static RobotDrive drivetrainRobotDrive;
    public static Encoder drivetrainLeftEncoder;
    public static Encoder drivetrainRightEncoder;
    public static Encoder drivetrainDriveLeftEncoder;
    public static Encoder drivetrainRightDriveEncoder;
    public static Solenoid drivetrainShiftSolenoid;
    public static Compressor drivetrainCompressor;
    public static CANTalon highGoalShooterHighGoalTalon1;
    public static CANTalon highGoalShooterHighGoalTalon2;
    public static Servo servoTestServo1;
    public static SpeedController winchWinchSpark;
    public static CANTalon gearElevatorGearElevatorTalon;
    public static CANTalon gearSlideGearSlideTalon;
    public static DigitalInput gearSlideSlideCenterSensor;
    public static Solenoid gearGrabberGearGrabSolenoid;
    public static SpeedController floorBeltFloorSpark;
    public static SpeedController transBeltTransSpark;
    public static SpeedController lowGoalShooterLowGoalSpark;
    public static SpeedController highGoalElevatorHighGoalSpark;
    public static SpeedController ballIntakeIntakeSpark;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainLeftdrive = new Spark(0);
        LiveWindow.addActuator("Drivetrain", "Leftdrive", (Spark) drivetrainLeftdrive);
        
        drivetrainRightdrive = new Spark(1);
        LiveWindow.addActuator("Drivetrain", "Rightdrive", (Spark) drivetrainRightdrive);
        
        drivetrainRobotDrive = new RobotDrive(drivetrainLeftdrive, drivetrainRightdrive);
        
        drivetrainRobotDrive.setSafetyEnabled(true);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(0.5);
        drivetrainRobotDrive.setMaxOutput(0.95);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrainLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "LeftEncoder", drivetrainLeftEncoder);
        drivetrainLeftEncoder.setDistancePerPulse(1.0);
        drivetrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "RightEncoder", drivetrainRightEncoder);
        drivetrainRightEncoder.setDistancePerPulse(1.0);
        drivetrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainDriveLeftEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "DriveLeftEncoder", drivetrainDriveLeftEncoder);
        drivetrainDriveLeftEncoder.setDistancePerPulse(1.0);
        drivetrainDriveLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainRightDriveEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "RightDriveEncoder", drivetrainRightDriveEncoder);
        drivetrainRightDriveEncoder.setDistancePerPulse(1.0);
        drivetrainRightDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainShiftSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("Drivetrain", "ShiftSolenoid", drivetrainShiftSolenoid);
        
        drivetrainCompressor = new Compressor(0);
        
        
        highGoalShooterHighGoalTalon1 = new CANTalon(1);
        LiveWindow.addActuator("HighGoalShooter", "HighGoalTalon1", highGoalShooterHighGoalTalon1);
        
        highGoalShooterHighGoalTalon2 = new CANTalon(2);
        LiveWindow.addActuator("HighGoalShooter", "HighGoalTalon2", highGoalShooterHighGoalTalon2);
        
        servoTestServo1 = new Servo(8);
        LiveWindow.addActuator("ServoTest", "Servo 1", servoTestServo1);
        
        winchWinchSpark = new Talon(9);
        LiveWindow.addActuator("Winch", "WinchSpark", (Talon) winchWinchSpark);
        
        gearElevatorGearElevatorTalon = new CANTalon(0);
        LiveWindow.addActuator("GearElevator", "GearElevatorTalon", gearElevatorGearElevatorTalon);
        
        gearSlideGearSlideTalon = new CANTalon(3);
        LiveWindow.addActuator("GearSlide", "GearSlideTalon", gearSlideGearSlideTalon);
        
        gearSlideSlideCenterSensor = new DigitalInput(8);
        LiveWindow.addSensor("GearSlide", "SlideCenterSensor", gearSlideSlideCenterSensor);
        
        gearGrabberGearGrabSolenoid = new Solenoid(0, 1);
        LiveWindow.addActuator("GearGrabber", "GearGrabSolenoid", gearGrabberGearGrabSolenoid);
        
        floorBeltFloorSpark = new Spark(3);
        LiveWindow.addActuator("FloorBelt", "FloorSpark", (Spark) floorBeltFloorSpark);
        
        transBeltTransSpark = new Spark(5);
        LiveWindow.addActuator("TransBelt", "TransSpark", (Spark) transBeltTransSpark);
        
        lowGoalShooterLowGoalSpark = new Spark(4);
        LiveWindow.addActuator("LowGoalShooter", "LowGoalSpark", (Spark) lowGoalShooterLowGoalSpark);
        
        highGoalElevatorHighGoalSpark = new Spark(6);
        LiveWindow.addActuator("HighGoalElevator", "HighGoalSpark", (Spark) highGoalElevatorHighGoalSpark);
        
        ballIntakeIntakeSpark = new Spark(2);
        LiveWindow.addActuator("BallIntake", "IntakeSpark", (Spark) ballIntakeIntakeSpark);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
