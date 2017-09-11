package com.thomson.concurrent.cookbook.ch4.creating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 类说明
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
        LOGGER.info("{}: task{} created on: {}", Thread.currentThread().getName(), Thread.currentThread().getName());
    }
}
