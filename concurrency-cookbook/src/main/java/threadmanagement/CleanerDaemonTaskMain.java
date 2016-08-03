package threadmanagement;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThomsonTang
 * @version 7/2/14
 */
public class CleanerDaemonTaskMain {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();

        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
