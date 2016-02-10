package com.qualcomm.ftcrobotcontroller.opmodes;

//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.hardware.HiTechnicNxtGyroSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Chairman Zhao on 1/18/2016.
 */
public abstract class ConfiguredOpMode extends LinearOpMode {
    protected DcMotor dLeft, dRight, sLeft, sRight, sweep;                //The 'd' prefix indicates a drivetrain component, the 's' prefix indicates a slide component
    protected Servo bRack, bTilt, hLeft, hRight;                          /*The 'b' prefix indicates a bucket component, the 'h' prefix indicates a hanger-manipulator
                                                                          bRack = Rack and Pinion, bTilt = Servo for tilting bucket*/
    protected DcMotor[] linSlide;
    //protected GyroSensor gyro;
    //private final float JOY_PWR_MULT = (float) 0.8;
    protected void stopRobot(){
        dLeft.setPower(0);
        dRight.setPower(0);
        sLeft.setPower(0);
        sRight.setPower(0);
        sweep.setPower(0);
    }
    public void reverseMotor(DcMotor motor){
        if(!(motor.getDirection() == DcMotor.Direction.REVERSE))
            motor.setDirection(DcMotor.Direction.REVERSE);
    }
    public void runOpMode() throws InterruptedException{
        dLeft = hardwareMap.dcMotor.get("DL");
        dRight = hardwareMap.dcMotor.get("DR");
        sLeft = hardwareMap.dcMotor.get("SL");
        reverseMotor(sLeft);
        reverseMotor(dRight);
        sRight = hardwareMap.dcMotor.get("SR");
        sweep = hardwareMap.dcMotor.get("S");
        bRack = hardwareMap.servo.get("R");
        bTilt = hardwareMap.servo.get("T");
        hLeft = hardwareMap.servo.get("HL");
        hRight = hardwareMap.servo.get("HR");
        linSlide = new DcMotor[2];
        linSlide[0] = sLeft;
        linSlide[1] = sRight;
        //gyro = hardwareMap.gyroSensor.get("gyro");
        //gyro.calibrate();
        bRack.setPosition(0.5);
        bTilt.setPosition(0.5);

    }
}
