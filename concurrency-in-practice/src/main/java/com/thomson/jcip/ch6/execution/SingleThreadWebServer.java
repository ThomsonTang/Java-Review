package com.thomson.jcip.ch6.execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <h2>Executing Tasks Sequentially</h2>
 *
 * Sequential Web Server
 * 任务可以被串行地执行，但是这样性能非常糟糕。
 *
 * @author Thomson Tang
 * @version Created: 23/08/2017.
 */
public class SingleThreadWebServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            while (true) {
                Socket connection = serverSocket.accept();
                handleRequest(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket connection) {
        // handling the request...
    }
}
