package com.thomson.concurrent.cookbook.ch3.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * <h2>changing data between concurrent task.</h2>
 *
 * At this point, both threads (consumer and producer) are in {@code Exchanger} and it changes
 * the data structures, so when the consumer returns from the {@code exchange()} method, it will
 * have a buffer with 10 strings. When the producer returns from the {@code exchange()} method,
 * it will have an empty buffer to fill again. This operation will be repeated 10 times.
 *
 * @author Thomson Tang
 * @version Created: 07/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();
        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
