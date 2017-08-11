package com.thomson.effective.concurrency.item67;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This is the test class for the {@link ObservableSet}.
 *
 * @author Thomson Tang
 * @version Created: 20/07/2017.
 */
public class ObservableSetTest {
    private ObservableSet<Integer> observableSet;

    @Before
    public void ready() {
        observableSet = new ObservableSet<>(new HashSet<>());
    }

    /**
     * Print the number from 0 through 99.
     */
    @Test
    public void testAdded() {
        observableSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println("element = [" + element + "]");
            }
        });
        for (int i = 0; i < 100; i++) {
            observableSet.add(i);
        }
        Assert.assertEquals("the size of observable set", 100, observableSet.size());
    }

    /**
     * Suppose we replace the addObserver call with one that passes an observer that prints the integer value that was
     * added to the set and removes itself if the value is 23.
     *
     * Now we are in  trouble. We are trying to remove an element from a list in the midst of iterating over it, which
     * is illegal. The iteration in the notifyElementAdded method is in a synchronized block to prevent concurrent
     * modification, but it doesn't prevent the iterating thread itself from calling back into the observable set and
     * modifying its observers list.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void testRemoveSelfWhen23() {
        observableSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(Thread.currentThread().getName() + ": element = [" + element + "]");
                if (element == 23) {
                    set.removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": observable set will add: " + i);
            observableSet.add(i);
        }
    }

    /**
     * Observer that uses a background thread needlessly, it cause a deadlock.
     *
     * Let's write an observer that attempts to unsubscribe, but instead of calling removeObserver directly, it engages
     * the services of another thread to do the deed. This observer uses an executor service. This time we don't get an
     * exception, we get a deadlock.
     *
     * This example is contrived because there is no reason for the observer to use a background thread, but the problem
     * is real. Invoking alien methods from synchronized regions has caused many deadlocks in real systems, such as GUI
     * toolkits.
     */
    @Test
    public void testRemoveUsingBackgroundThread() {
        observableSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println("element = [" + element + "]");
                if (element == 23) {
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> observer = this;
                    try {
                        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                set.removeObserver(observer);
                            }
                        }).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex.getCause());
                    } finally {
                        executor.shutdown();
                    }
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            observableSet.add(i);
        }
    }
}
