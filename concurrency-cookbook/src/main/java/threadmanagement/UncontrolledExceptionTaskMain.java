package threadmanagement;

/**
 * Processing uncontrolled exceptions in a thread.
 *
 * 1. CheckedException: must be specified in the throws clause of a method or caught inside them.
 * ex: IOException, ClassNotFoundException if this exception is thrown inside the run() method of a
 * Thread object, we have to catch and treat, because the run() method doesn't accept a throws
 * clause.
 *
 * 2. UncheckedException: don't have to be specified or caught. ex: NumberFormatException if this
 * exception is thrown inside the run() method of a Thread object, the default behavior is to write
 * stack trace in the console and exit the program. But java provides us with a mechanism to catch
 * and treat the unchecked exceptions throw in a Thread object to avoid the program ending.
 *
 * @author ThomsonTang
 * @date 7/7/14
 */
public class UncontrolledExceptionTaskMain {
    public static void main(String[] args) {
        Task rightTask = new Task("123");
        Thread rightThread = new Thread(rightTask);

        Task wrongTask = new Task("thomson");
        Thread wrongThread = new Thread(wrongTask);
        wrongThread.setUncaughtExceptionHandler(new ExceptionHandler());

        //这里需要注意的是, 异常仅对当前线程本身产生影响, 对其他没有异常抛出的线程则无影响
        wrongThread.start();
        rightThread.start();
    }
}
