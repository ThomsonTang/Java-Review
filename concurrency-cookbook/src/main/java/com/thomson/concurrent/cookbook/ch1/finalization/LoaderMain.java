package com.thomson.concurrent.cookbook.ch1.finalization;

import java.util.Date;

/**
 * <h1>Waiting for the finalization of a thread.</h1>
 *
 * @author ThomsonTang
 * @version 7/1/14
 */
public class LoaderMain {
    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread dataSourceThread = new Thread(dataSourcesLoader, "DataSourceThread");

        NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
        Thread networkConnectionThread = new Thread(networkConnectionsLoader, "NetworkConnectionThread");

        dataSourceThread.start();
        networkConnectionThread.start();

        //TODO: 此处是在main线程中同步另外两个线程，这样只能保证main线程等待另外两个线程完成任务。如何在线程A中join线程B呢？
        try {
            dataSourceThread.join();
            networkConnectionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded.%s\n", new Date());
    }
}
