package effective.mthdcommon2allobjs.item8;

import java.awt.*;

/**
 * Obey the general contract when overriding equals.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 6/24/13
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * violates symmetry.
     * example:
     * ==========================================================
     * Point p = new Point(1, 2);
     * ColorPoint c = new ColorPoint(1, 2, Color.RED);
     * ==========================================================
     */
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof ColorPoint))
//            return false;
//        return super.equals(o) && ((ColorPoint)o).color == color;
//    }

    /**
     * violates transitivity.
     * example:
     * ============================================================
     * ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
     * Point p2 = new Point(1, 2);
     * ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
     * ============================================================
     * p1.equals(p2) and p2.equals(p3) return true, but p1.equals(p3) returns false.
     *
     * @param obj
     * @return
     */
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Point))
//            return false;
//
//        if (!(obj instanceof ColorPoint))
//            return obj.equals(this);
//
//        return super.equals(obj) && ((ColorPoint) obj).color == color;
//    }
}
