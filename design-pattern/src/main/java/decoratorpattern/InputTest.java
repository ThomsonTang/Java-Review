package decoratorpattern;

import java.io.*;

/**
 * Client Test decorator pattern.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/2/13
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            File file = new File("test");
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(file)));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
