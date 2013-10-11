package network;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket echoServer = null;
        Socket clientSocket = null;

        try {
            echoServer = new ServerSocket(4444);
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }

        try {
            clientSocket = echoServer.accept();
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine, outputLine;
        KnockKnockProtocol kkp = new KnockKnockProtocol();

        outputLine = kkp.processInput(null);
        out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
            outputLine = kkp.processInput(inputLine);
            out.println(outputLine);
            if (outputLine.equals("Bye."))
                break;
        }

        out.close();
        in.close();
        clientSocket.close();
        echoServer.close();
    }
}
