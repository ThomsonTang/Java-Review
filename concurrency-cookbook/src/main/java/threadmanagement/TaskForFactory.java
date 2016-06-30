package threadmanagement;

import java.util.concurrent.TimeUnit;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class TaskForFactory implements Runnable {

    @Override public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
