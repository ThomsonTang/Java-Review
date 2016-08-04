package threadmanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * <h2>Define a thread factory will be used to create threads</h2>
 *
 * <p> Java provides an interface, the {@link java.util.concurrent.ThreadFactory} interface to
 * implement a {@code Thread} object factory. Some advanced utilities of the Java concurrency API
 * use thread factories to create threads. </p>
 *
 * @author Thomson Tang
 * @see java.util.concurrent.ThreadFactory
 */
public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, String.format("%s-Thread_%s", name, counter));
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> iterator = stats.iterator();

        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

}
