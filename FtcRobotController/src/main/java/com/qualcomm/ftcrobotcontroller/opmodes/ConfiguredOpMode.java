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
    protected DcMotor dLeft, dRight, dL2, dR2, sLeft, sRight, sweep;                //The 'd' prefix indicates a drivetrain component, the 's' prefix indicates a slide component
    protected Servo hook, door, hLeft, hRight;                          /*The 'b' prefix indicates a bucket component, the 'h' prefix indicates a hanger-manipulator
                                                                          bRack = Rack and Pinion, bTilt = Servo for tilting bucket*/
    protected DcMotor[] linSlide;
    //protected GyroSensor gyro;
    //private final float JOY_PWR_MULT = (float) 0.8;
    public final double WHEEL_DIAMETER = 2.75, TICKS_PER_INCH = 1440/WHEEL_DIAMETER;
    protected void stopRobot(){
        dLeft.setPower(0);
        dRight.setPower(0);
        sLeft.setPower(0);
        sRight.setPower(0);
        sweep.setPower(0);
        dL2.setPower(0);
        dR2.setPower(0);
    }
    public void reverseMotor(DcMotor motor){
        if(!(motor.getDirection() == DcMotor.Direction.REVERSE))
            motor.setDirection(DcMotor.Direction.REVERSE);
    }
    public void runOpMode() throws InterruptedException{
        dLeft = hardwareMap.dcMotor.get("DL");
        dRight = hardwareMap.dcMotor.get("DR");
        sLeft = hardwareMap.dcMotor.get("SL");
        dL2 = hardwareMap.dcMotor.get("FL");
        dR2 = hardwareMap.dcMotor.get("FR");
        reverseMotor(sLeft);
        reverseMotor(dLeft);
        reverseMotor(dL2);
        sRight = hardwareMap.dcMotor.get("SR");
        sweep = hardwareMap.dcMotor.get("S");
        hook = hardwareMap.servo.get("R");
        door = hardwareMap.servo.get("T");
        hLeft = hardwareMap.servo.get("HL");
        hRight = hardwareMap.servo.get("HR");
        linSlide = new DcMotor[2];
        linSlide[0] = sLeft;
        linSlide[1] = sRight;
        //gyro = hardwareMap.gyroSensor.get("gyro");
        //gyro.calibrate();
        hook.setPosition(0.5);
        door.setPosition(0.5);

    }
}
