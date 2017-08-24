package com.thomson.concurrent.cookbook.ch3.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这儿将CountDownLatch单独拎出来，创建了一个对象，供 VideoConference2 和 Participant2 共用。
 *
 * 这么做的目的主要是为了验证此种方法能否解决输出结果不一致的问题，如下：
 *
 * <pre>
 *     VideoConference: Initialization: 10 participants.
 *     Participant-1 has arrived.
 *     Participant-3 has arrived.
 *     VideoConference: Waiting for 8 participants.
 *     VideoConference: Waiting for 9 participants.
 *     Participant-6 has arrived.
 *     VideoConference: Waiting for 7 participants.
 *     Participant-4 has arrived.
 *     VideoConference: Waiting for 6 participants.
 * </pre>
 *
 * 但结果还是没能解决。应该考虑对{@code arrive()} 方法进行同步，但是简单的在方法声明处加上关键字{@code synchronized}
 * 依然无效，这是因为每个参会者对象都拥有独立的对象内置锁，无法起到同步作用。所以应该使用类级别的同步代码块或者用{@code Lock}
 * 机制来同步也是可以的。
 *
 * @author Thomson Tang
 * @version Created: 24/08/2017.
 */
public class Main2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Lock lock = new ReentrantLock();

        VideoConference2 conference2 = new VideoConference2(countDownLatch);
        Thread thread = new Thread(conference2);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Participant2 participant2 = new Participant2(countDownLatch, lock, "Participant-" + i);
            Thread thread1 = new Thread(participant2);
            thread1.start();
        }
    }
}
