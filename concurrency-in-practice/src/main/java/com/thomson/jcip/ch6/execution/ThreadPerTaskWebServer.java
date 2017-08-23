package com.thomson.jcip.ch6.execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <h2>Explicitly Creating Threads for Tasks</h2>
 *
 * Web Server that starts a new thread for each request.
 * 在web服务器中为每个请求启动一个新的线程，这种方法虽然能够提高并发性，但是无限制的创建线程同样会导致很多问题。因此最好不要这样做。
 *
 * @author Thomson Tang
 * @version Created: 23/08/2017.
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }

    public static void handleRequest(Socket socket) {
        // handling the request...
    }
}
