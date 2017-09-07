package com.thomson.concurrent.cookbook.ch3.exchanger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * The Producer class.
 *
 * @author Thomson Tang
 * @version Created: 07/09/2017.
 */
public class Producer implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    // this will be the data structure that the producer will interchange with the consumer.
    private List<String> buffer;

    // this will be the exchanger object that will be used to synchronize producer and consumer.
    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

    }
}
