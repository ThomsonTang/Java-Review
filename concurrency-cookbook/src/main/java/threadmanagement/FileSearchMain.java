package threadmanagement;

import java.util.concurrent.TimeUnit;

/**
 * The main class to search a file.
 *
 * @author ThomsonTang
 * @version 6/24/14
 */
public class FileSearchMain {
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("/Users/ThomsonTang/temp", "ershoufang.html");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
