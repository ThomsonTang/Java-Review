package commandpattern;

import org.junit.Before;
import org.junit.Test;

/**
 * 遥控器测试场景
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/16/13
 */
public class RemoteControllerTest {
    private SimpleRemoteController simpleRemoteController;
    private Light light;
    private LightOnCommand lightOnCommand;

    private GarageDoor garageDoor;
    private GarageDoorOpenCommand garageDoorOpenCommand;


    @Before
    public void prepare() {
        simpleRemoteController = new SimpleRemoteController();
        light = new LivingRoomLight();
        lightOnCommand = new LightOnCommand(light);

        garageDoor = new GarageDoor();
        garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
    }

    @Test
    public void testButtonWasPressed() {
        simpleRemoteController.setCommand(lightOnCommand);
        simpleRemoteController.buttonWasPressed();
    }

    @Test
    public void testGarageDoorUp() {
        simpleRemoteController.setCommand(garageDoorOpenCommand);
        simpleRemoteController.buttonWasPressed();
    }
}
