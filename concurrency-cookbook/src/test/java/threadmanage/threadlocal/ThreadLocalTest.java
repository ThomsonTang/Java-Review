package threadmanage.threadlocal;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import com.thomson.concurrent.cookbook.ch1.threadlocal.UnsafeTask;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/24/16-19:24
 */
public class ThreadLocalTest {

    @Test
    public void testWithExclusiveUnsafeTaskInstance() {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new UnsafeTask());
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testWithSingleSameUnsafeTaskInstance() {
        UnsafeTask task = new UnsafeTask();
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
