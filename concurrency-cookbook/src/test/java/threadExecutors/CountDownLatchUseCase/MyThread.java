package threadExecutors.CountDownLatchUseCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/25/16-16:34
 */
public class MyThread extends Thread {
    MyObject instance;
    private final CountDownLatch startSignal;
    private final CountDownLatch stopSignal;

    public MyThread(CountDownLatch startSignal, CountDownLatch stopSignal) {
        this.startSignal = startSignal;
        this.stopSignal = stopSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            instance = ObjectFactory.getInstance();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            stopSignal.countDown();
        }
    }
}
