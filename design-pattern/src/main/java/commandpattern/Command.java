package commandpattern;

/**
 * All command objects implements the same interface, which consist of one method execute().
 *
 * 命令接口，所有的操作动作都应该实现该接口。接口中定义了一个 execute 方法，表示动作的执行。
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/16/13
 */
public interface Command {
    public void execute();
}
