package effective.methods.item39;

import java.util.Date;

/**
 * Make defensive copies when needed
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/12/13
 */

// Broken "immutable" time period class
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start
     * @param end
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}
