package com.thomson.concurrent.cookbook.ch3.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 视频会议
 *
 * @author Thomson Tang
 * @version Created: 24/08/2017.
 */
public class VideoConference2 implements Runnable {
    private final CountDownLatch countDownLatch;

    public VideoConference2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", countDownLatch.getCount());
        try {
            countDownLatch.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
