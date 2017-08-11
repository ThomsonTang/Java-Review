package com.thomson.concurrent.cookbook.ch4.multiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Create the task class.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/18/16-17:00
 */
public class Task implements Callable<Result> {
    private static final Logger logger = LoggerFactory.getLogger(Task.class);
    private String name;
    private final CountDownLatch countDownLatch;

    public Task(String name) {
        this(name, null);
    }

    public Task(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Result call() throws Exception {
        logger.info("{}: Starting...", this.name);
        try {
            long duration = (long) (Math.random() * 10);
            logger.info("{}: Waiting {} seconds for results.", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }

        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int) (Math.random() * 100);
        }

        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        logger.info("{}: Ends.", this.name);
        countDownLatch.countDown();
        return result;
    }
}
