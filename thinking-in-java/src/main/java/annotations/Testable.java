package annotations;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/2/13
 */
public class Testable {
    public void execute() {
        System.out.println("Executing ...");
    }

    @Test void testExecute() {
        execute();
    }
}
