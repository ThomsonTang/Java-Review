package threadmanagement;

import java.util.concurrent.TimeUnit;

/**
 * The main class to test the use of ThreadLocal.
 *
 * @author ThomsonTang
 * @date 7/8/14
 */
public class ThreadLocalTaskMain {
    public static void main(String[] args) {
        // unsafe task
        UnsafeTask task = new UnsafeTask();

        // safe task
//        SafeTask task = new SafeTask();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
