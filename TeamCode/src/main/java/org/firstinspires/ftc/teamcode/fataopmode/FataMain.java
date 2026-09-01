package org.firstinspires.ftc.teamcode.fataopmode;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.fataopmode.api.opmode.AllianceColour;
import org.firstinspires.ftc.teamcode.fataopmode.api.opmode.FataOpMode;
import utility.actionBase.ActionScheduler;
import com.pedropathing.util.PoseHistory;

public class FataMain {
    private static FataOpMode currentOpMode;
    private static AllianceColour allianceColour;

    private static ActionScheduler actionScheduler = new ActionScheduler();

    private static PoseHistory poseHistory;

    public static FataOpMode getCurrentOpMode() {
        return currentOpMode;
    }

    public static Telemetry getTelemetry() {
        return currentOpMode.telemetry;
    }

    public static Gamepad getGamepad1() {
        return currentOpMode.gamepad1;
    }

    public static Gamepad getGamepad2() {
        return currentOpMode.gamepad2;
    }

    public static AllianceColour getAllianceColor() {
        return allianceColour;
    }

    public static void setAllianceColor(AllianceColour allianceColour) {
        FataMain.allianceColour = allianceColour;
    }

    public static ActionScheduler getActionScheduler() {
        return actionScheduler;
    }


}
