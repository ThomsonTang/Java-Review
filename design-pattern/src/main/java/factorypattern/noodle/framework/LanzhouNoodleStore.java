package factorypattern.noodle.framework;

/**
 * Define LanzhouNoodleStore.
 *
 * @author Thomson Tang
 */
public class LanzhouNoodleStore extends NoodleStore {
    @Override protected Noodle createNoodle(String type) {
        if (type.equals("beef")) {
            return new LanzhouBeefNoodle();
        } else {
            return null;
        }
    }
}
