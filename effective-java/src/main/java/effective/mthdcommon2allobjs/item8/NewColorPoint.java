package effective.mthdcommon2allobjs.item8;

import java.awt.*;

/**
 * Add a value component without violating the equals contract.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 6/25/13
 */
public class NewColorPoint {
    private final Point point;
    private final Color color;

    public NewColorPoint(int x, int y, Color color) {
        if (null == color)
            throw new NullPointerException();
        point = new Point(x, y);
        this.color = color;
    }

    /**
     * @return the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NewColorPoint))
            return false;
        NewColorPoint cp = (NewColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
