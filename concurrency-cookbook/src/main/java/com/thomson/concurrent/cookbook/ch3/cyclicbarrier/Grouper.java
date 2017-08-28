package com.thomson.concurrent.cookbook.ch3.cyclicbarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class calculates the total number of occurrences of the number in the matrix.
 *
 * @author Thomson Tang
 * @version Created: 28/08/2017.
 */
public class Grouper implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Grouper.class);

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        LOGGER.info("Grouper: Processing results...");

        int[] data = results.getData();
        for (int number : data) {
            finalResult += number;
        }

        LOGGER.info("Grouper: Total result: {}", finalResult);
    }
}
