package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.pedro.Constants;



@TeleOp(name = "Simple OpMode")
public class SimpleOpMode extends OpMode {
    private Follower follower;
    private Intake intake;
    private Shooter shooter;

    /**
     * This method is call once when init is played, it initializes the follower
     **/
    @Override
    public void init() {
        // Set Starting Pose

        follower = Constants.create(hardwareMap);
        intake = new Intake(hardwareMap);
        shooter = new Shooter(hardwareMap);

    }

    /**
     * This method is called continuously after Init while waiting to be started.
     **/
    @Override
    public void init_loop() {
    }


    /**
     * This method is called once at the start of the OpMode.
     **/
    @Override
    public void start() {

        shooter.setShooterState(false);
        intake.setIntakeState(false);

    }

    /**
     * This is the main loop of the opmode and runs continuously after play
     **/
    @Override
    public void loop() {
        //Call this once per loop
        follower.manual(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );

        //Start shooter
        if (gamepad1.leftBumperWasPressed()) {
            shooter.setShooterState(true);
        }

        // Start Intake
        if (gamepad1.rightBumperWasPressed()) {
            intake.setDirection(1);
            intake.setIntakeState(true);

        }

        //Stop shooter
        if (gamepad1.left_trigger_pressed) {
            shooter.setShooterState(false);

        }

        //Stop Intake
        if (gamepad1.right_trigger_pressed) {
            intake.setIntakeState(false);

        }

        if (gamepad1.aWasPressed()){
            intake.setDirection(-1);
            intake.setIntakeState(true);
        }

        // Update all subsystems
        shooter.update();
        intake.update();
        follower.update();
    }
}

