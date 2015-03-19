package factorypattern.noodle.abstractfactory;

/**
 * The new noodle store.
 *
 * @author Thomson Tang
 */
public abstract class NewNoodleStore {

    public NewNoodle orderNoodle(String type) {
        NewNoodle newNoodle = createNewNoodle(type);

        newNoodle.prepare();
        newNoodle.make();
        newNoodle.cook();
        newNoodle.fill();

        return newNoodle;
    }

    protected abstract NewNoodle createNewNoodle(String type);
}
