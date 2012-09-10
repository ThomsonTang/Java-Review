package object;

import java.io.*;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/6/12
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8023;
        try {
            Socket client = new Socket(serverName, port);
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inputStream = client.getInputStream();
            DataInputStream in = new DataInputStream(inputStream);
            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
