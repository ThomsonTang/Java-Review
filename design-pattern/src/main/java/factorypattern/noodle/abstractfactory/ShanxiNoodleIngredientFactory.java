package factorypattern.noodle.abstractfactory;

import factorypattern.noodle.abstractfactory.ingredient.*;

import java.util.Arrays;
import java.util.List;

/**
 * The Shanxi noodle ingredient factory.
 *
 * @author Thomson Tang
 */
public class ShanxiNoodleIngredientFactory implements NoodleIngredientFactory {
    @Override public Flour createFlour() {
        return new CommonFlour();
    }

    @Override public Soup createSoup() {
        return new CleanSoup();
    }

    @Override public List<Material> createMaterials() {
        return Arrays.asList(new Egg(), new Tomato());
    }
}
