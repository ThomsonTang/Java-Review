package com.thomson.jcip.ch5.building;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Using {@code CountDownLatch} for starting and stopping Threads in Timing tests.
 *
 * @author Thomson Tang
 * @version Created: 19/08/2017.
 */
public class TestHarness {
    public long timeTasks(int threads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await(); //每个线程起初都在等待，直到所有的线程都准备就绪，也就是statGate的计数器为零时。
                        try {
                            task.run();
                        } finally {
                            endGate.countDown(); //执行完一个任务后，endGate的计数器减1
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }

        long start = System.nanoTime();
        startGate.countDown(); //此刻startGate的计数器变为零，所有线程一起开始执行任务
        endGate.await(); //主线程开始等待，直到endGate的计数器为零
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        TestHarness testHarness = new TestHarness();
        try {
            long time = testHarness.timeTasks(10, new Task());
            System.out.println("time = [" + time + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("doing something...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
