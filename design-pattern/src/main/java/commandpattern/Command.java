package commandpattern;

/**
 * All command objects implements the same interface, which consist of one method execute().
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/16/13
 */
public interface Command {
    public void execute();
}
