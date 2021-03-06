/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package edu.wpi.first.wpilibj.templates;
package org.usfirst.frc2016.robot2017;

/**
 *
 * @author Montagna
 */
// This class provides the system defaults
// These should be updated after tuning the cRio NV RAM incase we need to change
// the cRio
public class Defaults {
    
    // Drive train voltage limit
    protected static final double DRIVETRAIN_VOLTAGE_LIMIT_DEFAULT = .95;

// Autonomous Time Defaults
    protected static final double AUT_SHOOTING_DELAY = .5;

// Autonomous Other Defaults
    protected static final double AUT_ENCODER_DISTANCE_10FT = 100; //Distance in inches
    protected static final double AUT_RIGHT_Y = -.8;
    protected static final double AUT_LEFT_Y = .8;

// Autonomous Straight Gear
    protected static final double STRAIGHTGEARSPEED = -0.4;
    protected static final double STRAIGHTGEARDISTANCE = 84.5;
// Elevator presets
    protected static final double ELEVATORPOSITION1 = 0;
    protected static final double ELEVATORPOSITION2 = 1000;
    protected static final double ELEVATORPOSITION3 = 7000;
    
// Gear Slide Limits
    protected static final double SLIDEUPPERLIMIT = .5;
    protected static final double SLIDELOWERLIMIT = -.5;

// Wheel Speeds
    protected static final double WHEEL_SPEED0 = 400;
    protected static final double WHEEL_SPEED1 = 700;
    protected static final double WHEEL_SPEED2 = 1500;
    protected static final double WHEEL_SPEED3 = 2900;

//
}

