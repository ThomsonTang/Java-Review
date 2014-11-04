package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Daemon Threads
 * Daemon threads don't prevent the program from ending.
 *
 * @author Thomson Tang
 */
public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // must call before start()
            daemon.start();
        }

        System.out.println("All daemons started.");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
