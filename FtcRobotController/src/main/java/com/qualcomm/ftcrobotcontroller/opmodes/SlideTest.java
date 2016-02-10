package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Chairman Zhao on 1/17/2016.
 */
public class SlideTest extends OpMode {
    DcMotor dLeft, dRight, sLeft, sRight;
    Servo bRack, bTilt, hLeft, hRight;
    public void init(){
        //dLeft = hardwareMap.dcMotor.get("DL");
        //dRight = hardwareMap.dcMotor.get("DR");
        sLeft = hardwareMap.dcMotor.get("SL");
        sRight = hardwareMap.dcMotor.get("SR");
        sRight.setDirection(DcMotor.Direction.REVERSE);
    }
    public void loop(){
        //float lThrottle = Range.clip(gamepad1.left_stick_y, -1, 1);
        //float rThrottle = Range.clip(gamepad1.right_stick_y, -1, 1);
        float sThrottle = gamepad2.right_stick_y;
        float slide = Range.clip(sThrottle, -1, 1);
        //dLeft.setPower(lThrottle);
        //dRight.setPower(rThrottle);
        sLeft.setPower(slide);
        sRight.setPower(slide);
    }
    public void stop(){

    }
}
