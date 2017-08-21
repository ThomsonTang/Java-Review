package com.thomson.concurrent.cookbook.ch2.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A job class implements the {@link Runnable}.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/25/16-18:07
 */
public class Job implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Job.class);
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        logger.info("{}: Going to print a document.", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        logger.info("{}: The document has been printed.", Thread.currentThread().getName());
    }
}
