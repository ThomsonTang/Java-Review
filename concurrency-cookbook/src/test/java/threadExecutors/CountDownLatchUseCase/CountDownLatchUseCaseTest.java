package threadExecutors.CountDownLatchUseCase;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * {@link CountDownLatch CountDownLatch} Use-Cases
 *
 * <ul>
 * <li>1. Achieving Maximum Parallelism, start a number of threads at the same time to achieve maximum parallelism.</li>
 * <li>2. Waiting for several threads to complete</li>
 * </ul>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/25/16-11:29
 */
public class CountDownLatchUseCaseTest {

    @Test
    public void shouldCreateOnlySingleInstanceOfAClassWhenTestedWithParallelThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        final ObjectFactory factory = new ObjectFactory();
        final CountDownLatch startSignal = new CountDownLatch(1);

        class MyThread extends Thread {
            MyObject instance;

            @Override
            public void run() {
                try {
                    startSignal.await();
                    instance = factory.getInstance();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        int threadCount = 1000;
        MyThread[] threads = new MyThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
        startSignal.countDown();
        for (MyThread myThread : threads) {
            myThread.join();
        }
        MyObject instance = factory.getInstance();
        for (MyThread myThread : threads) {
            assertEquals(instance, myThread.instance);
        }
        System.out.println("spent: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldCreateOnlySingleInstanceOfAClassWhenTestedWithParallelThreads2() throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadCount = 1000;
        final ObjectFactory factory = new ObjectFactory();
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch stopSignal = new CountDownLatch(threadCount);

        class MyThread extends Thread {
            MyObject instance;

            @Override
            public void run() {
                try {
                    startSignal.await();
                    instance = factory.getInstance();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    stopSignal.countDown();
                }
            }
        }

        MyThread[] threads = new MyThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
        startSignal.countDown();
        stopSignal.await();
        MyObject instance = factory.getInstance();
        for (MyThread myThread : threads) {
            assertEquals(instance, myThread.instance);
        }
        System.out.println("spent: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void testTheUseCase1() throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadCount = 1000;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch stopSignal = new CountDownLatch(threadCount);
        MyThread[] threads = new MyThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new MyThread(startSignal, stopSignal);
            threads[i].start();
        }
        startSignal.countDown();
        stopSignal.await();
        MyObject instance = ObjectFactory.getInstance();
        for (MyThread myThread : threads) {
            assertEquals(instance, myThread.instance);
        }
        System.out.println("spent: " + (System.currentTimeMillis() - start));
    }
}

