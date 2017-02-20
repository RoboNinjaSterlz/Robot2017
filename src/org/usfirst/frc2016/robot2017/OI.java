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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc2016.robot2017.POVTrigger;
import org.usfirst.frc2016.robot2017.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shiftLowButton;
    public Joystick driveLeft;
    public JoystickButton driveStraightButton;
    public JoystickButton driveStraightButtonDone;
    public JoystickButton shiftHighButton;
    public Joystick driveRight;
    public JoystickButton winchStopButton;
    public JoystickButton elevatorHighButton;
    public JoystickButton elevatorPrePickupButton;
    public JoystickButton elevatorLowButton;
    public JoystickButton floorBeltInButton;
    public JoystickButton compLowGoalButton;
    public JoystickButton lowGoalInButton;
    public JoystickButton floorBeltOutButton;
    public JoystickButton compGearGrabButton;
    public JoystickButton gearReleaseButton;
    public JoystickButton gearSlideZeroButton;
    public JoystickButton compPrePickupButton;
    public Joystick operatorJoy;
    public JoystickButton winchLiftButton;
    public Joystick cCI;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public POVTrigger POVFWDButton;
    public POVTrigger POVREVButton;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        cCI = new Joystick(3);
        
        winchLiftButton = new JoystickButton(cCI, 1);
        winchLiftButton.whileHeld(new WinchLift());
        operatorJoy = new Joystick(2);
        
        compPrePickupButton = new JoystickButton(operatorJoy, 11);
        compPrePickupButton.whenPressed(new CompPreparePickup());
        gearSlideZeroButton = new JoystickButton(operatorJoy, 12);
        gearSlideZeroButton.whileHeld(new CenterSlide());
        gearReleaseButton = new JoystickButton(operatorJoy, 1);
        gearReleaseButton.whenPressed(new GearRelease());
        compGearGrabButton = new JoystickButton(operatorJoy, 2);
        compGearGrabButton.whenPressed(new CompGrab());
        floorBeltOutButton = new JoystickButton(operatorJoy, 6);
        floorBeltOutButton.whileHeld(new FloorBeltOut());
        lowGoalInButton = new JoystickButton(operatorJoy, 5);
        lowGoalInButton.whileHeld(new LowGoalIn());
        compLowGoalButton = new JoystickButton(operatorJoy, 3);
        compLowGoalButton.whileHeld(new CompLowGoal());
        floorBeltInButton = new JoystickButton(operatorJoy, 4);
        floorBeltInButton.whileHeld(new FloorBeltIn());
        elevatorLowButton = new JoystickButton(operatorJoy, 11);
        elevatorLowButton.whenPressed(new ElevatorLow());
        elevatorPrePickupButton = new JoystickButton(operatorJoy, 9);
        elevatorPrePickupButton.whileHeld(new ElevatorPrePickup());
        elevatorHighButton = new JoystickButton(operatorJoy, 7);
        elevatorHighButton.whenPressed(new ElevatorHigh());
        winchStopButton = new JoystickButton(operatorJoy, 8);
        winchStopButton.whenReleased(new WinchStop());
        driveRight = new Joystick(1);
        
        shiftHighButton = new JoystickButton(driveRight, 10);
        shiftHighButton.whenPressed(new ShiftHigh());
        driveStraightButtonDone = new JoystickButton(driveRight, 11);
        driveStraightButtonDone.whenReleased(new TankDrive());
        driveStraightButton = new JoystickButton(driveRight, 11);
        driveStraightButton.whenPressed(new DriveStraight());
        driveLeft = new Joystick(0);
        
        shiftLowButton = new JoystickButton(driveLeft, 7);
        shiftLowButton.whenPressed(new ShiftLow());


        // SmartDashboard Buttons
        SmartDashboard.putData("SpeedSetup", new SpeedSetup());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        POVFWDButton = new POVTrigger(1);
        POVFWDButton.whileHeld(new IntakeOut());
        POVREVButton = new POVTrigger(3);
        POVREVButton.whileHeld(new CompBallIntake());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveLeft() {
        return driveLeft;
    }

    public Joystick getDriveRight() {
        return driveRight;
    }

    public Joystick getOperatorJoy() {
        return operatorJoy;
    }

    public Joystick getCCI() {
        return cCI;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

