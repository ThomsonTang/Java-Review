package com.thomson.concurrent.cookbook.ch1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * This class will divide 1000 between random numbers until the random generator generates a zero
 * and the exception is thrown.
 *
 * @author Thomson Tang
 * @version Created ：2016-7/2/16-18:04
 */
public class DividedTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(DividedTask.class);

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / ((int) random.nextDouble() * 1000);
            logger.info("the result: {}: {}", Thread.currentThread().getId(), result);
            if (Thread.currentThread().isInterrupted()) {
                logger.info("the thread {}: Interrupted.", Thread.currentThread().getId());
                return;
            }
        }

    }
}
