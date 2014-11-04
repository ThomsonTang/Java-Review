package utils;

import java.util.concurrent.TimeUnit;

/**
 * We can find out if a thread is a daemon by calling isDaemon(). If a thread is a daemon,
 * then any threads it creates will automatically be daemons.
 *
 * @author Thomson Tang
 */

class Daemon implements Runnable {
    private Thread[] threads = new Thread[10];

    @Override public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println("DaemonSpawn " + i + " Started.");
        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println("thread[" + i + "].isDaemon() = " + threads[i].isDaemon());
        }

        while (true) {
            Thread.yield();
        }
    }
}


class DaemonSpawn implements Runnable {
    @Override public void run() {
        while (true) {
            Thread.yield();
        }
    }
}


public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
