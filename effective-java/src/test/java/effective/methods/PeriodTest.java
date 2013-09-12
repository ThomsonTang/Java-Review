package effective.methods;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/12/13
 */
public class PeriodTest {
    private Period period;
    private Date start;
    private Date end;

    @Before
    public void prepare() {
        start = new Date("2013-11-12");
        end = new Date("2013-10-13");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPeriod() {
        period = new Period(start, end);
    }
}
