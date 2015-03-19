package factorypattern.pizza;

/**
 * An interface for the factory that is going to create all our ingredients.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/14/13
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Cheese createCheese();
    public Clam createClam();
}
