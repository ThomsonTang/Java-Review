package thread_synchronization_utilities.wait4MultipleConcurrentEvents;

import java.util.concurrent.CountDownLatch;

/**
 * implements video-conference.
 *
 * @author Thomson Tang
 * @version Created ：2016-24/10/2016-17:50
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;

    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    /**
     * This method will be called each time a participant arrives to the video conference.
     *
     * @param name the name of participant
     */
    public void arrive(String name) {
        System.out.printf("%s has arrived.", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
