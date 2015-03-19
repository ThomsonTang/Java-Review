package factorypattern.pizza;

import java.util.ArrayList;

/**
 * Abstract pizza class, all the concrete pizzas will derive from this.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/13/13
 */
public abstract class Pizza {
    String name;
    //String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    Dough dough;
    Cheese cheese;
    Clam clam;

    abstract void prepare();

//    void prepare() {
//        System.out.println("Preparing " + name);
//        System.out.println("Tossing dough...");
//        System.out.println("Adding sauce...");
//        System.out.println("Adding toppings: ");
//        for (int i = 0; i < toppings.size(); i++) {
//            System.out.println(" " + toppings.get(i));
//        }
//    }

    void bake() {
        System.out.println("Bake for 25 minutes.");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices.");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
