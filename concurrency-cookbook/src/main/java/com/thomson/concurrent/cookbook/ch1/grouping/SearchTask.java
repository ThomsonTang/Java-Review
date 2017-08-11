package com.thomson.concurrent.cookbook.ch1.grouping;

import com.thomson.concurrent.cookbook.ch1.grouping.Result;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A task simulates searching action.
 *
 * @author ThomsonTang
 * @version 7/10/14
 */
public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: start\n", name);

        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
    }

    private void doTask() throws InterruptedException {
        Random random = new Random(new Date().getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }
}
