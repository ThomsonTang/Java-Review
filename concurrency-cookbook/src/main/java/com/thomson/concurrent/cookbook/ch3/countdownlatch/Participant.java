package com.thomson.concurrent.cookbook.ch3.countdownlatch;

import java.util.concurrent.TimeUnit;

/**
 * This class represents each participant in the video conference.
 *
 * @author Thomson Tang
 * @version Created ：2016-24/10/2016-17:58
 */
public class Participant implements Runnable {
    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
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
        conference.arrive(name);
    }
}
