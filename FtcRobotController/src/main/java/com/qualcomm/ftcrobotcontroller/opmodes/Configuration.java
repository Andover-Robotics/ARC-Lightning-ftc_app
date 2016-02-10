package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Chairman Zhao on 1/18/2016.
 */
public class Configuration extends OpMode {
    private DcMotor dLeft, dRight, sLeft, sRight, sweep;                //The 'd' prefix indicates a drivetrain component, the 's' prefix indicates a slide component
    private Servo bRack, bTilt, hLeft, hRight;                          /*The 'b' prefix indicates a bucket component, the 'h' prefix indicates a hanger-manipulator
                                                                          bRack = Rack and Pinion, bTilt = Servo for tilting bucket*/
    //private final float JOY_PWR_MULT = (float) 0.8;
    public void init(){                                                 //Basic initiallization of motor and servo objects
        dLeft = hardwareMap.dcMotor.get("DL");
        dRight = hardwareMap.dcMotor.get("DR");
        sLeft = hardwareMap.dcMotor.get("SL");
        sRight = hardwareMap.dcMotor.get("SR");
        sweep = hardwareMap.dcMotor.get("S");
       /* Don't initiallize servos for testing phase
        bRack = hardwareMap.servo.get("R");
        bTilt = hardwareMap.servo.get("T");
        hLeft = hardwareMap.servo.get("HL");
        hRight = hardwareMap.servo.get("HR");*/
    }
    public void loop(){

    }
}
