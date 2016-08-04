package threadmanagement;

/**
 * <h2>Creating threads through a factory</h2>
 *
 * With the factory, we centralize the creation of objects with some advantages:
 *
 * <ul>
 * <li>It's easy to change the class of the objects created or the way we create these objects.</li>
 * <li>It's easy to limit the creation of objects for limited resources. For example,
 * we can only have <i>n</i> objects of a type.</li>
 * <li>It's easy to generate statistical data about the creation of the objects.</li>
 * </ul>
 *
 * <p> Java provides an interface, the {@link java.util.concurrent.ThreadFactory} interface to
 * implement a {@code Thread} object factory. Some advanced utilities of the Java concurrency API
 * use thread factories to create threads. </p>
 *
 * @author Thomson Tang
 */
public class ThreadFactoryMain {

    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
        TaskForFactory taskForFactory = new TaskForFactory();

        Thread thread;
        System.out.printf("Starting the threads\n");
        for (int i = 0; i < 10; i++) {
            thread = myThreadFactory.newThread(taskForFactory);
            thread.start();
        }

        System.out.printf("Factory status:\n");
        System.out.printf("%s\n", myThreadFactory.getStats());
    }
}
