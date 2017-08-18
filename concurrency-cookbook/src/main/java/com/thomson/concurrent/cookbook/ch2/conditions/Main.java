package com.thomson.concurrent.cookbook.ch2.conditions;

/**
 * <h2>How it works...</h2>
 *
 * <p>The key to this example is the {@code set()} and {@code get()} methods of the {@link
 * EventStorage} class. First of all, the {@code set()} method checks if there is free space in the
 * storage attribute. If it's full, it calls the {@code wait()} method to wait for free space. When
 * the other thread calls the {@code notifyAll()} method, the thread wakes up and checks the
 * condition again. The {@code notifyAll()} method doesn't guarantee that the thread will wake up.
 * This process is repeated until there is free space in the storage and it can generate a new event
 * and store it.</p>
 *
 * <p>The behavior of the {@code get()} method is similar. First, it checks if there are events on
 * the storage. If the {@link EventStorage} class is empty, it calls the {@code wait()} method to
 * wait for events. Where the other thread calls the {@code notifyAll()} method, the thread wakes up
 * and checks the condition again until there are some events in the storage.</p>
 *
 * <p>You have to keep checking the conditions and calling the {@code wait()} method in a
 * <i>while</i> loop. You can't continue until the condition is <i>true</i>.</p>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/16/16-18:13
 */
public class Main {

    public static void main(String[] args) {
        EventStorage<String> storage = new EventStorage<>();

        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);

        thread2.start();
        thread1.start();
    }
}
