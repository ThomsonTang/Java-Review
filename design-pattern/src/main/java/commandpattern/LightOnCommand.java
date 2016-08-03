package commandpattern;

/**
 * We want to implement a command for turning a light on.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/16/13
 */
public class LightOnCommand implements Command {
    private Light light;

    /*
      The constructor is passed the specific light that this command is going to control.
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
