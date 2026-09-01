package org.firstinspires.ftc.teamcode.fataopmode.api.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class FataOpMode extends LinearOpMode {

    private final OpModeType type;
    private OpModeStage stage;
    private boolean endOpmode = false;

    public FataOpMode(){
        this.type = OpModeType.getOpModeTypeFor(this);
    }

    @Override
    public void runOpMode() throws InterruptedException {
//            INIT
        stage = OpModeStage.INIT;

        while (opModeInInit()) {
//            INIT_LOOP
            stage = OpModeStage.INIT_LOOP;
        }

        waitForStart();

        if(!isStopRequested()) {
//            PLAY
            stage = OpModeStage.PLAY;
        }

        while (opModeIsActive() && !isStopRequested() && ! endOpmode) {
//            LOOP
            stage = OpModeStage.LOOP;
        }
        // STOP
        stage = OpModeStage.STOP;
    }

    public void onInit() {}

    public void initLoop() {}

    public void onPlay() {}

    public void onStop() {}

    public OpModeStage getStage() {
        return stage;
    }

    public OpModeType getType() {
        return type;
    }

    public void endOpMode() {
        endOpmode = true;
    }
}
