package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Chairman Zhao on 1/22/2016.
 */
public class AutoBasic extends ConfiguredOpMode{
    public void runOpMode() throws InterruptedException{
        super.runOpMode();
        hLeft.setPosition(0);
        hRight.setPosition(1.0);
        waitForStart();
        hLeft.setPosition(1.0);
        hRight.setPosition(0);
        sleep(10000);
        dLeft.setPower(0.8);
        dRight.setPower(0.8);
        sweep.setPower(0.8);
        sleep(4000);
        stopRobot();
    }
}
