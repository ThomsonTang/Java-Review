package com.thomson.concurrent.cookbook.ch2.lock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/25/16-18:14
 */
public class MainTest {

    @Test
    public void testPrintJob() throws InterruptedException {
        long start = System.currentTimeMillis();
        PrintQueue printQueue = new PrintQueue();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
        countDownLatch.await();
        System.out.println("spent: " + (System.currentTimeMillis() - start));
    }
}
