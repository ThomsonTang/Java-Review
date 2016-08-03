package threadmanagement;

import java.util.concurrent.TimeUnit;

/**
 * Use the <tt>sleep()</tt> method to write the actual date every second.
 *
 * @author ThomsonTang
 * @version 6/26/14
 */
public class FileClockMain {
    public static void main(String[] args) {
        FileClock fileClock = new FileClock();
        Thread thread = new Thread(fileClock);
        thread.start();

        // Call sleep() method in the main Thread to waiting for 5 second.
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // interrupt the fileClock thread.
        thread.interrupt();
    }
}
