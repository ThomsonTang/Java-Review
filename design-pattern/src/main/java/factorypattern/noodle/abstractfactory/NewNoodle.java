package factorypattern.noodle.abstractfactory;

import factorypattern.noodle.abstractfactory.ingredient.Flour;
import factorypattern.noodle.abstractfactory.ingredient.Material;
import factorypattern.noodle.abstractfactory.ingredient.Soup;

import java.util.ArrayList;
import java.util.List;

/**
 * Define the new Noodle class.
 *
 * @author Thomson Tang
 */
public abstract class NewNoodle {
    String name;
    Flour flour;
    Soup soup;
    List<Material> materialList = new ArrayList<>();

    abstract void prepare();

    void make() {
        System.out.println("making " + name + " ......");
    }

    void cook() {
        System.out.println("cooking " + name + " ......");
    }

    void fill() {
        System.out.println("filling " + name + " ......");
    }

    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
