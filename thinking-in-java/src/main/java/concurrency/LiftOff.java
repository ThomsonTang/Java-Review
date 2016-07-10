package concurrency;

/**
 * <h2>Defining tasks</h2>
 *
 * To define a task, simply implement {@link java.lang.Runnable} and write a {@link Runnable#run()}
 * method to make the task do your bidding. For example, the following {@code LiftOff} task displays
 * the countdown before liftoff.
 *
 * The identifier {@link LiftOff#id} distinguishes between multiple instances of the task. It is
 * {@code final} because it is not expected to change once it is initialized.
 *
 * The call to the {@code static} method {@link Thread#yield()} inside {@link LiftOff#run()} is a
 * suggestion to the <i>thread scheduler</i> that says, "I've done the important parts of my cycle
 * and this would be a good time to switch to another task for a while." It's completely optional.
 *
 * @author thomsontang
 */
public class LiftOff implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "listoff") + ").";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
