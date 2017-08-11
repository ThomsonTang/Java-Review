package com.thomson.concurrent.cookbook.ch1.creating;

import java.util.concurrent.TimeUnit;

/**
 * Define a task will be used in thread factory.
 *
 * @author Thomson Tang
 */
public class TaskForFactory implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
