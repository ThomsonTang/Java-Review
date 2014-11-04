package concurrency;

/**
 * The most basic use of the Thread class.
 *
 * @author Thomson Tang
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff.");
    }
}
