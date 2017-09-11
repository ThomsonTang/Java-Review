package com.thomson.concurrent.cookbook.ch3.exchanger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * implement the consumer.
 *
 * The Consumer begins with an empty buffer and calls {@code Exchanger} to synchronize
 * with the producer. It needs data to consume.
 *
 * @author Thomson Tang
 * @version Created: 07/09/2017.
 */
public class Consumer implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    // data structure that the producer will interchange with consumer.
    private List<String> buffer;

    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 2; i++) {
            LOGGER.info("Consumer: Cycle {}", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                LOGGER.error("Consumer: the error: ", e);
            }

            LOGGER.info("Consumer: {}", buffer.size());

            for (int j = 0; j < 5; j++) {
                String message = buffer.get(0);
                LOGGER.info("Consumer: {}", message);
                buffer.remove(0);
            }

            cycle++;
        }

    }
}
