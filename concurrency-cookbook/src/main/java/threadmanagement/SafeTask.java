package threadmanagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The safe task which use thread-local variable to save the <i>startDate </i> attribute.
 *
 * <p> Thread-local variables store a value of an attribute for each {@link Thread} that uses one of
 * these variables. You can read the value using the <code>get()</code> method and change the value
 * using the <code>set()</code> method. The first time you access the value of a thread-local
 * variable, if it has no value for the Thread object that it is calling, the thread-local variable
 * calls the <code>initialValue()</code> method to assign a value for that Thread and return the
 * initial value.</p>
 *
 * @author ThomsonTang
 * @version 7/8/14
 */
public class SafeTask implements Runnable {
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Start thread: %s: %s\n", Thread.currentThread().getId(), startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished: %s: %s\n", Thread.currentThread().getId(), startDate.get());
    }
}
