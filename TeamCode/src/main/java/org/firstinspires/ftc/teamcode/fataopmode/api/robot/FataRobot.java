package org.firstinspires.ftc.teamcode.fataopmode.api.robot;

import com.qualcomm.hardware.lynx.LynxModule;
import org.firstinspires.ftc.teamcode.fataopmode.FataMain;
import org.firstinspires.ftc.teamcode.fataopmode.api.robot.hardware.Subsystem;

import java.util.List;

public class FataRobot {
    private final Subsystem[] subsystems= {

    };

    public void init() {
        for (Subsystem s : subsystems)
            s.hardwareInit();
        for (Subsystem s : subsystems) if (s.isEnabled()) s.opModeInit();

        List<LynxModule> allHubs = FataMain.getCurrentOpMode().hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }

    public void play() {
        for (Subsystem s : subsystems) if (s.isEnabled()) s.play();
    }

    public void loop() {
        for (Subsystem s : subsystems) if (s.isEnabled()) s.loop();
    }

    public void stop() {
        for (Subsystem s : subsystems) if (s.isEnabled()) s.stop();
    }

}
