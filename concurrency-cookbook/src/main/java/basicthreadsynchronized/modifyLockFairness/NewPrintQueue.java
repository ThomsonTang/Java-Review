package basicthreadsynchronized.modifyLockFairness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/31/16-18:18
 */
public class NewPrintQueue {
    private static final Logger logger = LoggerFactory.getLogger(NewPrintQueue.class);
    private final Lock lock = new ReentrantLock(true);

    /**
     * Print contents of the document. This method separate the simulation of printing in two blocks of code, freeing
     * the lock between them.
     *
     * @param document the document will be printed.
     */
    public void printJob(Object document) {
        lock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            logger.info("{} PrintQueue: Print a job during {} seconds.", Thread.currentThread().getName(), duration /
                    1000);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
        lock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            logger.info("{} PrintQueue: Print a job during {} seconds.", Thread.currentThread().getName(), duration /
                    1000);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }
}
