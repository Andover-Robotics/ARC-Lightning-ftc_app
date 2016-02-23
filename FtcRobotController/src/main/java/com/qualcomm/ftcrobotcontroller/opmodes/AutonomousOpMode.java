package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Chairman Zhao on 1/20/2016.
 */
public abstract class AutonomousOpMode extends ConfiguredOpMode{
    protected void clearEncoders(){
        dL2.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        dR2.setMode(DcMotorController.RunMode.RESET_ENCODERS);
    }
    protected void drive(double lPwr, double rPwr){
        dLeft.setPower((float)lPwr);
        dRight.setPower((float)rPwr);
        dL2.setPower((float)lPwr);
        dR2.setPower((float)rPwr);
    }
    protected void timedDrive(long ms) throws InterruptedException{
        drive(0.8, 0.8);
        sleep(ms);
        stopRobot();
        clearEncoders();
    }
    protected void encDrive(double in) throws InterruptedException{
        dL2.setTargetPosition((int) (in * TICKS_PER_INCH));
        drive(0.8, 0.8);
        while(dL2.getCurrentPosition() < dL2.getTargetPosition()){

        }
        stopRobot();
        sleep(100);
        clearEncoders();
    }
    protected void encTurn(double deg) throws InterruptedException{
        double robotCirc = 15.42 * Math.PI;
        if(deg > 0){
            dR2.setTargetPosition((int)(robotCirc * TICKS_PER_INCH * deg / 360.0));
            drive(-0.5, 0.5);
            while(dR2.getCurrentPosition() < dR2.getTargetPosition()){

            }
        }
        else if(deg < 0){
            dL2.setTargetPosition((int)(robotCirc * TICKS_PER_INCH * deg / 360.0));
            drive(0.5, -0.5);
            while(dL2.getCurrentPosition() < dL2.getTargetPosition());
        }
        stopRobot();
        sleep(100);
        clearEncoders();
    }
    /**protected void gyroTurn(int deg){
        while(gyro.getHeading() < deg && deg > 0){
            drive(-0.8, 0.8);
        }
        while(gyro.getHeading() < -deg && deg < 0){
            drive(0.8, -0.8);
        }
        stopRobot();
        gyro.resetZAxisIntegrator();
    }*/
    public void runOpMode() throws InterruptedException{
        super.runOpMode();
        dL2.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        dR2.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }
}
