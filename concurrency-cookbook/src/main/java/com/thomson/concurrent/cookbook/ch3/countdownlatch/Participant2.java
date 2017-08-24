package com.thomson.concurrent.cookbook.ch3.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 参会者
 *
 * @author Thomson Tang
 * @version Created: 24/08/2017.
 */
public class Participant2 implements Runnable {
    private final CountDownLatch countDownLatch;
    private final Lock lock;
    private final String name;

    public Participant2(CountDownLatch countDownLatch, Lock lock, String name) {
        this.countDownLatch = countDownLatch;
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arrive();
    }

    private void arrive() {
        synchronized (Participant2.class) {
            System.out.printf("%s has arrived.\n", name);
            countDownLatch.countDown();
            System.out.printf("VideoConference: Waiting for %d participants.\n", countDownLatch.getCount());
        }
    }
}
