package com.thomson.concurrent.cookbook.ch1.finalization;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Sleep 6 seconds for the loader beginning and finished.
 *
 * @author ThomsonTang
 * @version 7/1/14
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connection loading: %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Network connection load finished: %s\n", new Date());
    }
}
