package factorypattern.noodle.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Define Noodle class.
 *
 * @author Thomson Tang
 */
public abstract class Noodle {
    String name;
    String flour;
    String soup;
    List<String> materialList = new ArrayList<>();

    void prepare() {
        System.out.println("preparing " + name + " ......");
        System.out.println("preparing flour... ");
        System.out.println("preparing soup... ");
        System.out.println("adding other materials: ");

        for (String material : materialList) {
            System.out.println("adding " + material);
        }
    }

    void make() {
        System.out.println("making " + name + " ......");
    }

    void cook() {
        System.out.println("cooking " + name + " ......");
    }

    void fill() {
        System.out.println("filling " + name + " ......");
    }

    String getName() {
        return name;
    }
}
