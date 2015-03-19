package factorypattern.pizza;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/13/13
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
//        dough = "Extract Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    void prepare() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices.");
    }
}
