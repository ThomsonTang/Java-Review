package object;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/6/12
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingServer extends Thread{
    private ServerSocket serversocket;

    public GreetingServer(int port) throws IOException {
        serversocket = new ServerSocket(port);
        serversocket.setSoTimeout(10000);
    }

    public void run() {
        while(true) {
            System.out.println("wait for client on port: " + serversocket.getLocalPort() + "......");
            try {
                Socket server = serversocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\ngoodbye!");
                server.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
    
    public static void main(String[] args) {
        int port = 8023;
        try {
            Thread t = new GreetingServer(8023);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
