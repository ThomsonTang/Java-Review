package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Producing return values from tasks.
 *
 * @author Thomson Tang
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() {
        return "result of TaskWithResult " + id;
    }
}


public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> future : results) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
