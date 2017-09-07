package com.thomson.jcip.ch8.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 执行任务的定义。
 *
 * @author Thomson Tang
 * @version Created: 07/09/2017.
 */
public class Task implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            LOGGER.info("{}: start to execute...", taskName);
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(5);
            LOGGER.info("{}: execution end.", taskName);
        } catch (InterruptedException e) {
            LOGGER.error("{}: failed to execute.", taskName);
        }
    }
}
