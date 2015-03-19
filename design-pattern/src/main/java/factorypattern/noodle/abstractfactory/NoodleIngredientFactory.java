package factorypattern.noodle.abstractfactory;

import factorypattern.noodle.abstractfactory.ingredient.Flour;
import factorypattern.noodle.abstractfactory.ingredient.Material;
import factorypattern.noodle.abstractfactory.ingredient.Soup;

import java.util.List;

/**
 * The abstract factory method for creating ingredient.
 *
 * @author Thomson Tang
 */
public interface NoodleIngredientFactory {
    Flour createFlour();

    Soup createSoup();

    List<Material> createMaterials();
}
