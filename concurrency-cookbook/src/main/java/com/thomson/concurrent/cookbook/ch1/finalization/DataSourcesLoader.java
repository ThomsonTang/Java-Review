package com.thomson.concurrent.cookbook.ch1.finalization;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <h1>Waiting for the finalization of a thread.</h1>
 *
 * @author ThomsonTang
 * @version 6/30/14
 */
public class DataSourcesLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data source loading: %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(4); // waiting for 4 seconds.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Data source load finished: %s\n", new Date());
    }
}
