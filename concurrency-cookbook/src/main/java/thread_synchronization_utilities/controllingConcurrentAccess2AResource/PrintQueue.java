package thread_synchronization_utilities.controllingConcurrentAccess2AResource;

import java.util.concurrent.Semaphore;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-19/10/2016-14:54
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds.\n", Thread.currentThread().getName()
                    , duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
