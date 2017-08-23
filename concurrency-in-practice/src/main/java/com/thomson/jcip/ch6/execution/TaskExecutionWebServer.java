package com.thomson.jcip.ch6.execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <h2>Web Server Using a Thread Pool.</h2>
 *
 * @author Thomson Tang
 * @version Created: 23/08/2017.
 */
public class TaskExecutionWebServer {
    private static final int NTHREAD = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREAD);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        // doing something...
    }
}
