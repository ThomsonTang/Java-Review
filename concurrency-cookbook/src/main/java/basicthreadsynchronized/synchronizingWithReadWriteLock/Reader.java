package basicthreadsynchronized.synchronizingWithReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements a reader of the values of the {@link PricesInfo} class attributes.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/26/16-18:22
 */
public class Reader implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Reader.class);
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            logger.info("{}: price1: {}", Thread.currentThread().getName(), pricesInfo.getPrice1());
            logger.info("{}: price2: {}", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
