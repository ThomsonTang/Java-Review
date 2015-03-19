package threadmanagement;

/**
 * Created by Intellij idea.
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
