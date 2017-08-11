package com.thomson.concurrent.cookbook.ch2.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class will implement the print queue.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/17/16-18:38
 */
public class PrintQueue {
    private static final Logger logger = LoggerFactory.getLogger(PrintQueue.class);
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            logger.info("{}: PintQueue: Printing a Job during {}  seconds.", Thread.currentThread().getName(),
                    (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            logger.error("the error occurred. ", e);
        } finally {
            queueLock.unlock();
        }
    }
}
