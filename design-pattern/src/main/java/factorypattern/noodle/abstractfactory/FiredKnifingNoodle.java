package factorypattern.noodle.abstractfactory;

/**
 * The fired knifing noodle.
 *
 * @author Thomson Tang
 */
public class FiredKnifingNoodle extends NewNoodle {
    NoodleIngredientFactory ingredientFactory;

    public FiredKnifingNoodle(NoodleIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override void prepare() {
        System.out.println("prepare " + name);

        flour = ingredientFactory.createFlour();
        materialList = ingredientFactory.createMaterials();
    }
}
