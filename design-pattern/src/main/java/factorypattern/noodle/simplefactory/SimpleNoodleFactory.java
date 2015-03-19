package factorypattern.noodle.simplefactory;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class SimpleNoodleFactory {

    public Noodle createNoodle(String type) {
        Noodle noodle;
        if (type.equals("thinner")) {
            noodle = new ThinnerNoodle();
        } else if (type.equals("thin")) {
            noodle = new ThinNoodle();
        } else if (type.equals("thick")) {
            noodle = new ThickNoodle();
        } else {
            noodle = new Noodle();
        }
        return noodle;
    }
}
