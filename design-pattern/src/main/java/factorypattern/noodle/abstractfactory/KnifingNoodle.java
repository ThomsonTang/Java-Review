package factorypattern.noodle.abstractfactory;

/**
 * The knifing noodle.
 *
 * @author Thomson Tang
 */
public class KnifingNoodle extends NewNoodle {
    NoodleIngredientFactory ingredientFactory;

    public KnifingNoodle(NoodleIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override void prepare() {
        System.out.println("Preparing " + name);

        flour = ingredientFactory.createFlour();
        soup = ingredientFactory.createSoup();
        materialList = ingredientFactory.createMaterials();
    }
}
