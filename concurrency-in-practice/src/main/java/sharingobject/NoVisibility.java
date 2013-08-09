package sharingobject;

/**
 * Sharing Variables without Synchronization. Don't do this.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/6/13
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
