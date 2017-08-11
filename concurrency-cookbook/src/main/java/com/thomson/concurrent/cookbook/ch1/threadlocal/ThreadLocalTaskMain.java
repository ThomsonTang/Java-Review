package com.thomson.concurrent.cookbook.ch1.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * <h1>Using local thread variables</h1>
 *
 * The main class to test the use of ThreadLocal or not.
 *
 * @author ThomsonTang
 * @version 7/8/14
 */
public class ThreadLocalTaskMain {
    public static void main(String[] args) {
        // unsafe task
//        UnsafeTask task = new UnsafeTask();

        // safe task
        SafeTask task = new SafeTask();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
