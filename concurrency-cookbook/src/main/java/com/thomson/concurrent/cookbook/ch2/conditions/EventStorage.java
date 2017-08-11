package com.thomson.concurrent.cookbook.ch2.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The event storage.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/11/16-17:56
 */
public class EventStorage {
    private static final Logger logger = LoggerFactory.getLogger(EventStorage.class);
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error("the error occurred.", e);
            }
        }
        ((LinkedList<Date>) storage).offer(new Date());
        logger.info("Set: {}", storage.size());
        notifyAll();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error("the error occurred.", e);
            }
        }
        logger.info("Get: {}: {}", storage.size(), ((LinkedList<?>) storage).poll());
        notifyAll();
    }
}
