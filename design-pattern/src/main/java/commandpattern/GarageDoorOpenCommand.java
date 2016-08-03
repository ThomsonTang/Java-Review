package commandpattern;

/**
 * 车库门打开操作
 * 打开车库门也抽象为一个命令，实现Command接口
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/16/13
 */
public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
