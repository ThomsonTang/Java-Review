package threadmanagement;

import java.util.Date;

/**
 * Waiting for the finalization of a thread.
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

        try {
            dataSourceThread.join();
            networkConnectionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded.%s\n", new Date());
    }
}
