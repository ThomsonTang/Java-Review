package factorypattern.noodle.abstractfactory;

/**
 * The beef noodle.
 *
 * @author Thomson Tang
 */
public class BeefNoodle extends NewNoodle {
    NoodleIngredientFactory ingredientFactory;

    public BeefNoodle(NoodleIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override void prepare() {
        System.out.println("Preparing" + name);

        flour = ingredientFactory.createFlour();
        soup = ingredientFactory.createSoup();
        materialList = ingredientFactory.createMaterials();
    }
}
