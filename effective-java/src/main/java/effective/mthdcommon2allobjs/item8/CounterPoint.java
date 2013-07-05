package effective.mthdcommon2allobjs.item8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Liskov substitution principle says that any important property of a type should also
 * hold for its subtypes, so that any method written for the type should work equally well
 * on its subtypes.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 6/25/13
 */
public class CounterPoint extends Point {

    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public int numberCreated() {
        return counter.get();
    }
}
