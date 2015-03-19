package factorypattern.noodle.abstractfactory;

/**
 * The new Shanxi noodle store.
 *
 * @author Thomson Tang
 */
public class ShanxiNoodleStore extends NewNoodleStore {
    @Override protected NewNoodle createNewNoodle(String type) {
        NewNoodle noodle = null;
        NoodleIngredientFactory ingredientFactory = new ShanxiNoodleIngredientFactory();
        if (type.equals("knifing")) {
            noodle = new KnifingNoodle(ingredientFactory);
            noodle.setName("Shanxi Knifing noodle");
        } else if (type.equals("fired-knife")) {
            noodle = new FiredKnifingNoodle(ingredientFactory);
            noodle.setName("Shanxi Fired knifing noodle");
        }
        return noodle;
    }
}
