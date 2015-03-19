package factorypattern.pizza;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/13/13
 */
public class NyStyleCheesePizza extends Pizza {
    public NyStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
//        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    void prepare() {
        // empty
    }
}
