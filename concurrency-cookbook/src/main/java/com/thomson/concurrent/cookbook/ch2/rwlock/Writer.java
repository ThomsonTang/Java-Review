package com.thomson.concurrent.cookbook.ch2.rwlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements a modifier of the values of the {@link PricesInfo} class attributes.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/26/16-18:27
 */
public class Writer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Writer.class);
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            logger.info("Writer: Attempt to modify the prices.");
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
            logger.info("Write: Prices has been modified.");
        }

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
