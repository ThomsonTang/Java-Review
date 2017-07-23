package effective.concurrency.item67;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

/**
 * This is a test class for {@link BetterObservableSet}.
 *
 * @author Thomson Tang
 * @version Created: 23/07/2017.
 */
public class BetterObservableSetTest {

    private BetterObservableSet<Integer> observableSet = null;

    @Before
    public void ready() {
        observableSet = new BetterObservableSet<>(new HashSet<>());
    }

    @Test
    public void testAdded() {
        observableSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(BetterObservableSet<Integer> set, Integer element) {
                System.out.println("element = [" + element + "]");
            }
        });
        for (int i = 0; i < 100; i++) {
            observableSet.add(i);
        }
        Assert.assertEquals("observable set size: ", 100, observableSet.size());
    }

    @Test
    public void testUnsubscribeWhen23() {
        observableSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(BetterObservableSet<Integer> set, Integer element) {
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
}
