package effective.enumsandannotations.item30;

/**
 * Print the object's weight on all planet.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/23/13
 */
public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = 175;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }
}
