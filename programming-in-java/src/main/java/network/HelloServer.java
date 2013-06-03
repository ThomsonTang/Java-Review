package network;

import java.io.*;
import java.net.*;

public class HelloServer extends Thread {
    private ServerSocket serverSocket;

    public HelloServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    public void run() {
        Socket server;
        BufferedReader in;
        PrintWriter out;

        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

                server = serverSocket.accept();
                System.out.println("connected to " + server.getRemoteSocketAddress());

                in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                System.out.println(in.readLine());

                out = new PrintWriter(server.getOutputStream(), true);
                out.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nBye!!");

                server.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new HelloServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
