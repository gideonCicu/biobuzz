package org.firstinspires.ftc.teamcode.fataopmode.api.robot.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;
import com.seattlesolvers.solverslib.hardware.motors.CRServo;
import org.firstinspires.ftc.teamcode.fataopmode.FataMain;

public interface hardware {

    default boolean isHardwareEnabled() {
        return true;
    }

    default MotorEx getDcMotorEx(String name) {
        return getDcMotorEx(name, isHardwareEnabled(), Motor.GoBILDA.RPM_435);
    }

    default MotorEx getDcMotorEx(String name, boolean enabled){
         return getDcMotorEx(name, enabled, Motor.GoBILDA.RPM_435);
    }

    default MotorEx getDcMotorEx(String name, boolean enabled, Motor.GoBILDA motorType) {
        MotorEx motor = new MotorEx(FataMain.getCurrentOpMode().hardwareMap, name, motorType);
        if (!enabled){
            motor.disable();
        }
        return motor;
    }

    default PidMotor getPidMotor(String name){
        return getPidMotor(name, true);
    }
    default PidMotor getPidMotor(String name, boolean enabled) {
        return enabled ?  new PidMotor((DcMotorEx) FataMain.getCurrentOpMode().hardwareMap.dcMotor.get(name)) :
                new PidMotor(new DecoyDcMotorEx());
    }

    default ServoEx getServo(String name) {
        return getServo(name, isHardwareEnabled());
    }

    default ServoEx getServo(String name, boolean enabled, )

    default ServoEx getServo(String name, boolean enabled) {

    }


    default CRServo getCRServo(String name) {
        return getCRServo(name,true);
    }

    default CRServo getCRServo(String name, boolean enabled) {
        return enabled ? FataMain.getCurrentOpMode()
                .hardwareMap.crservo.get(name) : new DecoyCRServo();
    }

    default DigitalChannel getDigitalChannel(String name) {
        return getDigitalChannel(name,true);
    }

    default DigitalChannel getDigitalChannel(String name, boolean enabled) {
        return enabled ? FataMain.getCurrentOpMode()
                .hardwareMap.digitalChannel.get(name) : new DecoyDigitalChannel();
    }

    default Limelight3A getLimelight() {
        return getLimelight(true);
    }

    default Limelight3A getLimelight(boolean enabled) {
        return enabled ? FataMain.getCurrentOpMode()
                .hardwareMap.get(Limelight3A.class, "lamlam") : DecoyLimelight3A.create();
    }

    default NormalizedColorSensor getSnesor(String name) {
        return getSnesor(name, true);
    }

    default NormalizedColorSensor getSnesor(String name, boolean enabled) {
        return enabled ? (NormalizedColorSensor) FataMain.getCurrentOpMode()
                .hardwareMap.colorSensor.get(name) : new DecoyNormalizedColourSensor() {
        };
    }

}
