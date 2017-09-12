package com.thomson.concurrent.cookbook.ch4.creating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 执行任务。
 *
 * @author Thomson Tang
 * @version Created: 11/09/2017.
 */
public class ExecTask implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecTask.class);

    private Date initDate;
    private String name;

    public ExecTask(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        LOGGER.info("{}: task{} created on: {}", Thread.currentThread().getName(), name, initDate);
        LOGGER.info("{}: task{} started on: {}", Thread.currentThread().getName(), name, new Date());
        try {
            Long duration = (long) (Math.random() * 10);
            LOGGER.info("{}: task{} doing a task during {} seconds.", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("{}: task{} finished on: {}", Thread.currentThread().getName(), name, new Date());
    }
}
