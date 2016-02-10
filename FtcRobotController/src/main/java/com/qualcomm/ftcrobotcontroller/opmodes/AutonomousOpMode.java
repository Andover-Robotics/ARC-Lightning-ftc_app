package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Chairman Zhao on 1/20/2016.
 */
public abstract class AutonomousOpMode extends ConfiguredOpMode{
    protected void drive(double lPwr, double rPwr){
        dLeft.setPower((float)lPwr);
        dRight.setPower((float)rPwr);
    }
    protected void timedDrive(long ms) throws InterruptedException{
        drive(0.8, 0.8);
        sleep(ms);
        stopRobot();
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
}
