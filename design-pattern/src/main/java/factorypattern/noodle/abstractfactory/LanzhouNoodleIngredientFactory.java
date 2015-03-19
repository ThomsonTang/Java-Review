package factorypattern.noodle.abstractfactory;

import factorypattern.noodle.abstractfactory.ingredient.*;

import java.util.Arrays;
import java.util.List;

/**
 * Lanzhou noodle ingredient factory.
 *
 * @author Thomson Tang
 */
public class LanzhouNoodleIngredientFactory implements NoodleIngredientFactory {
    @Override public Flour createFlour() {
        return new BestFlour();
    }

    @Override public Soup createSoup() {
        return new BeefSoup();
    }

    @Override public List<Material> createMaterials() {
        Material[] materials = {new Chili(), new Garlic(), new Redish()};
        return Arrays.asList(materials);
    }
}
