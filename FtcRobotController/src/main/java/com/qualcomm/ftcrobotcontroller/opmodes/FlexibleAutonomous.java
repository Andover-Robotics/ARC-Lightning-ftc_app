package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Chairman Zhao on 1/20/2016.
 */
public class FlexibleAutonomous extends AutonomousOpMode{
    private int NUM_VARS = 4;
    /**private boolean side = true, ramp = true, hanger = true, start = true;
    private final boolean BLUE = true, RED = false;
    private void assignVars(){
        while(!opModeIsActive()){
            if(gamepad1.x)
                side = BLUE;
            if(gamepad1.b)
                side = RED;
            if(gamepad1.a)
                ramp = BLUE;
            if(gamepad1.y)
                ramp = RED;
            if(gamepad1.left_bumper)
                hanger = true;
            if(gamepad1.left_trigger > 0.5)
                hanger = false;
            if(gamepad1.right_bumper)
                start = true;
            if(gamepad1.right_trigger > 0.5)
                start = false;
        }
    }*/
    private int[] varList = new int[NUM_VARS];
    private String[] varNames =
            {"Alliance: ", "Ramp: ", "Hangers: ", "Priority: "};
    private String[][] varVals = {
            {"Red", "Blue"},
            {"Red", "Blue", "No"},
            {"Yes", "No"},
            {"High", "Low"}
    };
    private void assignVars(){
        int i = 0;
        while(i < NUM_VARS){                                        //While the counting integer is less than the total number of autonomous variables
            if(i < 0)                                               //if i gets below 0, reset to 0 to avoid an ArrayOutOfBoundsException
                i = 0;
            telemetry.addData("1", varNames[i]);                    //Set the first line to the name of the autonomous variable
            telemetry.addData("3", "Press A to continue, B to go back");//Set the third line to instructions for continuing/changing previous vars
            boolean next = false;                                   //Placeholder boolean for determining whether or not to finallize
            while(!next){                                           //While not continuing
                int j = 0;                                          //Tracks the value of the variable given varVals
                if(gamepad1.dpad_right){                            //On right dPad, loop through tasks to the right
                    if(j < varVals[i].length - 1)
                        j++;                                        //If below limit, go to the right
                    else
                        j = 0;                                      //If at upper limit, return to beginning and loop
                }
                else if(gamepad1.dpad_left) {                        //On left dPad, loop through tasks to the left
                    if (j > 0)
                        j--;                                        //If above lower limit, go to the left
                    else
                        j = varVals[i].length - 1;                  //If at lower limit, go to end and loop back
                }
                telemetry.addData("2", varVals[i][j]);              //Display the value of the autonomous variable
                varList[i] = j;                                     //Set the value of the autonomous variable
                if(gamepad1.a)
                    next = true;
                else if(gamepad1.b) {
                    i -= 2;
                    next = true;
                }
            }
            telemetry.clearData();
            for(int k = 4; k < 5 + i; k++){
                telemetry.addData(Integer.toString(k), varNames[k] + varVals[k][varList[k]]);
            }
            if(i == NUM_VARS - 1) {                                 //If at end of var list
                next = false;                                       //reset placeholder boolean
                telemetry.addData("1", "Confirm?");                 //Ask to confirm selections
                telemetry.addData("2", "A- Yes, B- No");
                while(!next){
                    if(gamepad1.b) {                                //If b is pressed, return to last task
                        i--;
                        next = true;
                    }
                    else if(gamepad1.a)
                        next = true;
                }
            }
            i++;
        }
    }
    public void runOpMode() throws InterruptedException{
        assignVars();
        super.runOpMode();

    }
}
