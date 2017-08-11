package com.thomson.concurrent.cookbook.ch3.countdownlatch;

/**
 * <h1>Waiting for multiple concurrent events</h1>
 *
 * {@link java.util.concurrent.CountDownLatch} Class Use-Case:
 * The Java concurrency API provides a class that allows one or more threads to wait until a set operations are made.
 * It's the {@link java.util.concurrent.CountDownLatch} class.
 *
 * In this recipe, we will lean how to use the {@link java.util.concurrent.CountDownLatch} class implementing a
 * video-conference system. The video-conference system will wait for the arrival of all participants before it begins.
 *
 * The {@code Main} method create a {@link VideoConference} object that waits for 10 participants.
 *
 * <h2>How it works:</h2>
 * The {@link java.util.concurrent.CountDownLatch} class has three basic elements:
 * <ul>
 * <li>The initialization value that determines how many events the {@link java.util.concurrent.CountDownLatch} class
 * waits for.</li>
 * <li>The {@code await()} method, called by the threads that wait for the finalization of all events.</li>
 * <li>The {@code countDown()} method, called by the events when they finish their execution.</li>
 * </ul>
 *
 * @author Thomson Tang
 * @version Created ：2016-24/10/2016-18:01
 */
public class Main {
    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);

        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "Participant-" + i);
            Thread threadParticipant = new Thread(participant);
            threadParticipant.start();
        }
    }
}
