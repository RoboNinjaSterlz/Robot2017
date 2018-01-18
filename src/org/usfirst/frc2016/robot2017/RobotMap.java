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
import edu.wpi.first.wpilibj.DigitalInput;

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
    public static Solenoid drivetrainShiftSolenoid;
    public static Compressor drivetrainCompressor;
    public static CANTalon highGoalShooterHighGoalTalon1;
    public static Servo gearSlideGearSlideServo;
    public static SpeedController winchWinchSpark;
    public static CANTalon gearElevatorGearElevatorTalon;
    public static Solenoid gearGrabberGearGrabSolenoid;
    public static SpeedController floorBeltFloorSpark;
    public static SpeedController transBeltTransSpark;
    public static SpeedController lowGoalShooterLowGoalSpark;
    public static SpeedController highGoalElevatorHighGoalSpark;
    public static SpeedController ballIntakeIntakeSpark;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DigitalInput gearInDetector;
    public static DigitalInput didWeGrab;
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainLeftdrive = new Spark(0);
        LiveWindow.addActuator("Drivetrain", "Leftdrive", (Spark) drivetrainLeftdrive);
        drivetrainLeftdrive.setInverted(false);
        drivetrainRightdrive = new Spark(1);
        LiveWindow.addActuator("Drivetrain", "Rightdrive", (Spark) drivetrainRightdrive);
        drivetrainRightdrive.setInverted(false);
        drivetrainRobotDrive = new RobotDrive(drivetrainLeftdrive, drivetrainRightdrive);
        
        drivetrainRobotDrive.setSafetyEnabled(true);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(0.5);
        drivetrainRobotDrive.setMaxOutput(0.95);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrainLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "LeftEncoder", drivetrainLeftEncoder);
        drivetrainLeftEncoder.setDistancePerPulse(0.0657159156);
        drivetrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "RightEncoder", drivetrainRightEncoder);
        drivetrainRightEncoder.setDistancePerPulse(0.0657159156);
        drivetrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainShiftSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("Drivetrain", "ShiftSolenoid", drivetrainShiftSolenoid);
        
        drivetrainCompressor = new Compressor(0);
        LiveWindow.addActuator("Drivetrain", "Compressor", drivetrainCompressor);
        
        highGoalShooterHighGoalTalon1 = new CANTalon(1);
        LiveWindow.addActuator("HighGoalShooter", "HighGoalTalon1", highGoalShooterHighGoalTalon1);
        
        gearSlideGearSlideServo = new Servo(8);
        LiveWindow.addActuator("GearSlide", "GearSlideServo", gearSlideGearSlideServo);
        
        winchWinchSpark = new Talon(9);
        LiveWindow.addActuator("Winch", "WinchSpark", (Talon) winchWinchSpark);
        winchWinchSpark.setInverted(false);
        gearElevatorGearElevatorTalon = new CANTalon(0);
        LiveWindow.addActuator("GearElevator", "GearElevatorTalon", gearElevatorGearElevatorTalon);
        
        gearGrabberGearGrabSolenoid = new Solenoid(0, 1);
        LiveWindow.addActuator("GearGrabber", "GearGrabSolenoid", gearGrabberGearGrabSolenoid);
        
        floorBeltFloorSpark = new Spark(3);
        LiveWindow.addActuator("FloorBelt", "FloorSpark", (Spark) floorBeltFloorSpark);
        floorBeltFloorSpark.setInverted(false);
        transBeltTransSpark = new Spark(5);
        LiveWindow.addActuator("TransBelt", "TransSpark", (Spark) transBeltTransSpark);
        transBeltTransSpark.setInverted(false);
        lowGoalShooterLowGoalSpark = new Spark(4);
        LiveWindow.addActuator("LowGoalShooter", "LowGoalSpark", (Spark) lowGoalShooterLowGoalSpark);
        lowGoalShooterLowGoalSpark.setInverted(false);
        highGoalElevatorHighGoalSpark = new Spark(6);
        LiveWindow.addActuator("HighGoalElevator", "HighGoalSpark", (Spark) highGoalElevatorHighGoalSpark);
        highGoalElevatorHighGoalSpark.setInverted(false);
        ballIntakeIntakeSpark = new Spark(2);
        LiveWindow.addActuator("BallIntake", "IntakeSpark", (Spark) ballIntakeIntakeSpark);
        ballIntakeIntakeSpark.setInverted(false);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        gearInDetector = new DigitalInput(4);
        didWeGrab = new DigitalInput(5);
    }
}
