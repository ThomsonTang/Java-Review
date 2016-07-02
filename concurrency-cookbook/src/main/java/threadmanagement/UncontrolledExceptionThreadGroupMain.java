package threadmanagement;

/**
 * <h2>Processing uncontrolled exceptions in a group of threads</h2>
 *
 * <p>This class is to establish a method that captures all the uncaught exceptions thrown by any
 * {@code Thread} of the {@code ThreadGroup} class. </p>
 *
 * @author Thomson Tang
 * @version Created ：2016-7/2/16-16:52
 */
public class UncontrolledExceptionThreadGroupMain {
    public static void main(String[] args) {
        MyThreadGroup myThreadGroup = new MyThreadGroup("ThomsonThreadGroup");
        DividedTask task = new DividedTask();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(myThreadGroup, task);
            thread.start();
        }
    }
}
