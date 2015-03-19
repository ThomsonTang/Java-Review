package factorypattern.noodle.abstractfactory;

/**
 * The new Lanzhou noodle store.
 *
 * @author Thomson Tang
 */
public class LanzhouNoodleStore extends NewNoodleStore {
    @Override protected NewNoodle createNewNoodle(String type) {
        NewNoodle noodle = null;
        NoodleIngredientFactory ingredientFactory = new LanzhouNoodleIngredientFactory();

        if (type.equals("beef")) {
            noodle = new BeefNoodle(ingredientFactory);
            noodle.setName("Lanzhou style beef noodle");
        } else if (type.equals("fired")) {
            noodle = new FiredNoodle(ingredientFactory);
            noodle.setName("Lanzhou style fired noodle");
        }
        return noodle;
    }
}
