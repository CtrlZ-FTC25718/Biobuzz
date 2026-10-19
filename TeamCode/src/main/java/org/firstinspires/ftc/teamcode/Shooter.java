package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.ArrayList;

public class Shooter {
    private static DcMotor shooterMotorLeft;
    private static DcMotor shooterMotorRight;

    //State
    private boolean shooterOn;


    //Constructor
    public Shooter(HardwareMap map) {
        shooterMotorLeft = map.get(DcMotor.class, "shooterMotorLeft");
        shooterMotorLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        shooterMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        shooterMotorRight = map.get(DcMotor.class, "shooterMotorRight");
        shooterMotorRight.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public boolean getShooterState() {
        return shooterOn;
    }

    public void setShooterState(boolean newState) {
        shooterOn = newState;
    }

    public void update() {
        if (shooterOn) {
            shooterMotorRight.setPower(0.75);
            shooterMotorLeft.setPower(0.75);

        } else {
            shooterMotorRight.setPower(0.0);
            shooterMotorLeft.setPower(0.0);
        }
    }
}
