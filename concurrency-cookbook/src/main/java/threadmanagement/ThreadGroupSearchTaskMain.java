package threadmanagement;

import java.util.concurrent.TimeUnit;

/**
 * Group threads into a group
 * <p/>
 * This allows us to treat the threads of a group as a single unit and provides access to the Thread
 * objects that belong to a group to do an operation with them.
 * <p/>
 * Java provides the {@link ThreadGroup} class to work with groups of threads. A ThreadGroup object
 * can be formed by Thread objects and by another ThreadGroup object, generating a tree structure of
 * threads.
 *
 * @author ThomsonTang
 * @date 7/10/14
 * @see ThreadGroup
 */
public class ThreadGroupSearchTaskMain {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group: \n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        waitFinish(threadGroup);
        threadGroup.interrupt();
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
