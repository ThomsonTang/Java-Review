package factorypattern.noodle.framework;

/**
 * Define ShanxiNoodleStore.
 *
 * @author Thomson Tang
 */
public class ShanxiNoodleStore extends NoodleStore {
    @Override protected Noodle createNoodle(String type) {
        if (type.equals("knifing")) {
            return new ShanxiKnifingNoodle();
        } else {
            return null;
        }
    }
}
