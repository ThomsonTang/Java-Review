package factorypattern.noodle.framework;

/**
 * Define the LanzhouBeefNoodle and construct its material.
 *
 * @author Thomson Tang
 */
public class LanzhouBeefNoodle extends Noodle {
    public LanzhouBeefNoodle() {
        name = "Lanzhou Beef Noodle";
        flour = "best flour";
        soup = "best beef soup";

        materialList.add("chili"); //红辣椒
        materialList.add("garlic"); //青蒜
        materialList.add("radish"); //白萝卜
    }
}
