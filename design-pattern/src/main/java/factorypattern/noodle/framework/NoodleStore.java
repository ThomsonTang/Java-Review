package factorypattern.noodle.framework;

/**
 * Define NoodleStore for all franchises.
 *
 * @author Thomson Tang
 */
public abstract class NoodleStore {

    Noodle orderNoodle(String type) {
        Noodle noodle = createNoodle(type);

        noodle.prepare();
        noodle.make();
        noodle.cook();
        noodle.fill();

        return noodle;
    }

    protected abstract Noodle createNoodle(String type);
}
