package concurrency;

/**
 * <h2>The {@code Thread} class</h2>
 *
 * The most basic use of the {@link java.lang.Thread} class.
 *
 * @author Thomson Tang
 * @see MoreBasicThreads
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff.");
    }
}
