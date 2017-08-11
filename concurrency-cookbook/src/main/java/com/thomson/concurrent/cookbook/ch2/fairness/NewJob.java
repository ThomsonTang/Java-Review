package com.thomson.concurrent.cookbook.ch2.fairness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * This new job implements the printing contents of a document with {@link NewPrintQueue}.
 *
 * @author Thomson Tang
 * @version Created ：2016-9/2/16-11:19
 */
public class NewJob implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(NewJob.class);
    private NewPrintQueue printQueue;
    private CountDownLatch countDownLatch;

    public NewJob(NewPrintQueue printQueue) {
        this.printQueue = printQueue;
//        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        logger.info("{}: Going to print a document.", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        logger.info("{}: The document has been printed.", Thread.currentThread().getName());
    }
}
