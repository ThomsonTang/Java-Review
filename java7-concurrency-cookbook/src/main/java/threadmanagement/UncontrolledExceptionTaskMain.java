package threadmanagement;

/**
 * Processing uncontrolled exceptions in a thread.
 *
 *  1. CheckedException: must be specified in the throws clause of a method or caught inside them.
 *      ex: IOException, ClassNotFoundException
 *      if this exception is thrown inside the run() method of a Thread object, we have to catch and treat, because the
 *      run() method doesn't accept a throws clause.
 *
 *  2. UncheckedException: don't have to be specified or caught.
 *      ex: NumberFormatException
 *      if this exception is thrown inside the run() method of a Thread object, the default behavior is to write stack
 *      trace in the console and exit the program. But java provides us with a mechanism to catch and treat the unchecked
 *      exceptions throw in a Thread object to avoid the program ending.
 *
 * @author ThomsonTang
 * @date 7/7/14
 */
public class UncontrolledExceptionTaskMain {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
