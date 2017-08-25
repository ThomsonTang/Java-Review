package com.thomson.jcip.ch6.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * 支持关闭操作的Web服务器
 *
 * @author Thomson Tang
 * @version Created: 25/08/2017.
 */
public class LifecycleWebServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleWebServer.class);
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);

        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(conn);
                    }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
                    LOGGER.error("task submission rejected.", e);
                }
            }
        }
    }

    public void stop() {
        exec.shutdown();
    }

    private void handleRequest(Socket connection) {
        // do something...
        // if is shutdown request, then call stop() method.
    }
}
