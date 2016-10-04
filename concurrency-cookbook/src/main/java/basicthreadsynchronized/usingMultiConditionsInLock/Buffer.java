package basicthreadsynchronized.usingMultiConditionsInLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class will implement the buffer shared by producer and consumer.
 *
 * @author Thomson Tang
 * @version Created ：2016-9/6/16-15:10
 */
public class Buffer {
    private static final Logger logger = LoggerFactory.getLogger(Buffer.class);

    private LinkedList<String> buffer;
    private int maxSize;

    private ReentrantLock lock;
    private Condition lines;
    private Condition space;

    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        this.buffer = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.lines = lock.newCondition();
        this.space = lock.newCondition();
        this.pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();
            }
            buffer.offer(line);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}