package concurrency;

/**
 * <h1>Basic Threading</h1>
 *
 * A <strong>thread</strong> is a single sequential flow of control within a process. A single
 * process can thus have multiple concurrently executing tasks, but you program as if each task has
 * the CPU to itself.
 *
 * One of the great things about threading is that you are abstracted away from this layer, so your
 * code does not need to know whether it is running on a single CPU or many.
 *
 * The {@link LiftOff} is only a task, it is not a thread. When a class is derived from {@link
 * Runnable}, it must have a {@code run()} method, but that's nothing special-it doesn't produce any
 * innate threading abilities. To achieve threading behavior, you must explicitly attach a task to a
 * thread.
 *
 * @see BasicThreads
 * @see MoreBasicThreads
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
