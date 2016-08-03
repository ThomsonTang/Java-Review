package threadmanagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Create a task that write current time in console, sleeping for a random time, and
 * write time again in the end.
 *
 * @author ThomsonTang
 * @version 7/8/14
 */
public class UnsafeTask implements Runnable {
    Date startDate = new Date();

    @Override
    public void run() {
        System.out.printf("Start thread: %s: %s\n", Thread.currentThread().getId(), startDate);

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished: %s: %s\n", Thread.currentThread().getId(), startDate);
    }
}
