package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Chairman Zhao on 1/17/2016.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class Teleop2 extends ConfiguredOpMode {
    /*
    * Motors:
    ** dLeft/dRight - Drivetrain
    ** sLeft/sRight - Linear Slide
    ** sweep - Sweeper
    * Servos:
    ** bRack - Rack & Pinion for bucket
    ** bTilt - Bucket Tilt
    ** hLeft/hRight - Hanger Manipulators
    * */
    public final float JOY_PWR_MULT = (float) 0.8;
    public void runOpMode() throws InterruptedException{
        super.runOpMode();
        waitForStart();
        while(opModeIsActive()){
            powerMotor(dLeft, gamepad1.left_stick_y);
            powerMotor(dRight, gamepad1.right_stick_y);
            powerMotor(linSlide, gamepad2.right_stick_y);
            if(gamepad1.left_trigger > 0.1)
                powerMotor(sweep, gamepad1.left_trigger);
            else if(gamepad1.right_trigger > 0.1)
                powerMotor(sweep, -gamepad1.right_trigger);
            else{
                sweep.setPower(0);
            }
            /**incrementServo(bRack, 0.01, gamepad2.dpad_left, gamepad2.dpad_right);
            incrementServo(bTilt, 0.01, gamepad2.left_bumper, gamepad2.right_bumper);*/
            hardSetServo(bRack, 0, gamepad2.dpad_left);
            hardSetServo(bRack, 1, gamepad2.dpad_right);
            //hardSetServo(bRack, 0.5, gamepad2.a);
            hardSetServo(bTilt, 0.2, gamepad2.right_bumper);
            hardSetServo(bTilt, 0.8, gamepad2.left_bumper);
            //hardSetServo(bTilt, 0.5, gamepad2.b);
            hardSetServo(bTilt, 0.5, gamepad2.dpad_up);
            hardSetServo(bRack, 0.5, gamepad2.dpad_down);
            hardSetServo(hLeft, 0.5, gamepad1.dpad_left);
            hardSetServo(hLeft, 1, gamepad1.dpad_right);
            hardSetServo(hRight, 0, gamepad1.dpad_up);
            hardSetServo(hRight, 0.5, gamepad1.dpad_down);
        }
        stopRobot();
    }
    public void incrementServo(Servo s, double d, boolean b1, boolean b2) throws InterruptedException{
        double sPos = s.getPosition();
        if(b1) {
            sPos += d;
            sleep(100);
        }
        else if(b2) {
            sPos -= d;
            sleep(100);
        }
        sPos = Range.clip(sPos, 0, 1);
        s.setPosition(sPos);
    }
    public void powerMotor(DcMotor motor, float joyStick){
        float throttle = Range.clip(JOY_PWR_MULT * joyStick, -1, 1);     //Range.clip ensures that the throttles remain within a reasonable range
        motor.setPower(throttle);
    }
    public void powerMotor(DcMotor[] motors, float joyStick){
        float throttle = Range.clip(JOY_PWR_MULT * joyStick, -1, 1);     //Range.clip ensures that the throttles remain within a reasonable range
        for(DcMotor motor : motors){
            motor.setPower(throttle);
        }
    }
    public void hardSetServo(Servo s, double pos, boolean buttonPress) {
        if (buttonPress)
            s.setPosition(pos);
    }
}
