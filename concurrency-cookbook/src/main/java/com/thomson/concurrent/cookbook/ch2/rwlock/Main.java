package com.thomson.concurrent.cookbook.ch2.rwlock;

/**
 * <h2>Synchronizing data access with read/write locks</h2>
 *
 * @author Thomson Tang
 * @version Created ：2016-8/26/16-18:32
 */
public class Main {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader[] readers = new Reader[5];
        Thread[] threadReaders = new Thread[5];

        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadReaders[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            threadReaders[i].start();
        }
        threadWriter.start();
    }
}
