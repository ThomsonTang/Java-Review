package threadmanagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Create a date instance in a loop with 10 iterations, and call sleep() method to suspend execution
 * of the thread for one second as the tread throw the InterruptedException.
 *
 * @author ThomsonTang
 * @version 6/26/14
 */
public class FileClock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s, %s\n", i, new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The FileClock has been interrupted.\n");
            }
        }
    }
}
