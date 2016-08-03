package threadmanagement;

import java.util.Date;
import java.util.Deque;

/**
 * A daemon thread to clean the event.
 *
 * @author ThomsonTang
 * @version 7/2/14
 */
public class CleanerTask extends Thread {

    public static final int FOR_CLEAN_FLAG = 10000;
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (deque.size() == 0)
            return;

        delete = false;

        do {
            Event lastEvent = deque.getLast();
            difference = date.getTime() - lastEvent.getDate().getTime();

            if (difference > FOR_CLEAN_FLAG) {
                System.out.printf("Cleaner: %s\n", lastEvent.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > FOR_CLEAN_FLAG);

        if (delete) {
            System.out.printf("Cleaner: size of the queue: %d\n", deque.size());
        }
    }
}
