package effective.concurrency.item67;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类说明
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

    @Test
    public void testAdded() {
        observableSet.addObserver((set, element) -> System.out.println("element = [" + element + "]"));
        for (int i = 0; i < 100; i++) {
            observableSet.add(i);
        }
    }

    @Test
    public void testRemoveSelfWhen23() {
        observableSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println("element = [" + element + "]");
                if (element == 23) {
                    set.removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            observableSet.add(i);
        }
    }

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
