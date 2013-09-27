package commandpattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/16/13
 */
public class SimpleRemoteController {

    //We have one slot to hold our command, which will control one device.
    Command slot;

    public SimpleRemoteController() {}

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
