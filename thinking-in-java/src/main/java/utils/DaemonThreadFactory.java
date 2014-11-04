package utils;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
