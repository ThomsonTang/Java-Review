package com.thomson.concurrent.cookbook.ch2.conditions;

/**
 * This class implements the consumer of the example.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/16/16-18:11
 */
public class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
