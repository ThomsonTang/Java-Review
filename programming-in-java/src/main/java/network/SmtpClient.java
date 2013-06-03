package network; 

import java.net.*;
import java.io.*;

public class SmtpClient {
    public static void main(String[] args) throws IOException {
        Socket smtpSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            smtpSocket = new Socket("localhost", 7);
            out = new PrintWriter(smtpSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
        } catch (UnknownHostException ex) {
            System.err.println("Don't know about host!");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Couldn't get I/O for the connetion.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;

        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        smtpSocket.close();
    }
}
