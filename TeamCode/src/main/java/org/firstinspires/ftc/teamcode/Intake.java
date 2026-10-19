package org.firstinspires.ftc.teamcode;

//Imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.ArrayList;

//Hardware

public class Intake {

    private static DcMotor intakeMotor;

    //State
    private double power;
    private boolean intakeOn;

    private int direction;

    //Constructor
    public Intake(HardwareMap map) {
        intakeMotor = map.get(DcMotor.class, "intakeMotor");
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        direction = 1; //Default direction is forward (intake mode)

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int newDirection) { //Direction can be +1 or -1 to set direction
        direction = newDirection;
    }

    public boolean getIntakeState() {
        return intakeOn;
    }

    public void setIntakeState(boolean newState) {
        intakeOn = newState;
    }

    public void update() {
        if (intakeOn) {
            intakeMotor.setPower(direction * 1.0);

        } else {
            intakeMotor.setPower(direction * 0.0);
        }
    }
}
