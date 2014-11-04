package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * If more than one task is submitted to a SingleThreadExecutor, the tasks will be queued and
 * each task will run to completion before the next task is begun, all using the same thread.
 *
 * @author Thomson Tang
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
