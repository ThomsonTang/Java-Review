package network;

import java.io.*;
import java.net.*;

public class HelloClient {

    public static void main(String[] args) throws IOException {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        Socket client = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);

            client = new Socket(serverName, port);
            System.out.println("Connected to " + client.getRemoteSocketAddress());

            out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello from " + client.getLocalSocketAddress());

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Server says: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            in.close();
            client.close();
        }
    }
}
