package basicthreadsynchronized.modifyLockFairness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

import basicthreadsynchronized.synchronizingWithLock.Job;

/**
 * Modify the {@code Main} class the block of code that starts the threads.
 *
 * @author Thomson Tang
 * @version Created ：2016-9/2/16-11:12
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        int threadCount = 10;
//        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        NewPrintQueue printQueue = new NewPrintQueue();
        Thread[] jobs = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            jobs[i] = new Thread(new NewJob(printQueue));
        }

        for (int i = 0; i < threadCount; i++) {
           jobs[i].start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
