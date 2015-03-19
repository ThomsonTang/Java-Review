package factorypattern.noodle.abstractfactory;

/**
 * The fired noodle.
 *
 * @author Thomson Tang
 */
public class FiredNoodle extends NewNoodle {
    NoodleIngredientFactory ingredientFactory;

    public FiredNoodle(NoodleIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override void prepare() {
        System.out.println("Preparing " + name);

        flour = ingredientFactory.createFlour();
        materialList = ingredientFactory.createMaterials();
    }
}
