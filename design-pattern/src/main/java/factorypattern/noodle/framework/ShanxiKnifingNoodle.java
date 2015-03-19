package factorypattern.noodle.framework;

/**
 * Define ShanxiKnifingNoodle.
 *
 * @author Thomson Tang
 */
public class ShanxiKnifingNoodle extends Noodle {
    public ShanxiKnifingNoodle() {
        name = "Shangxi knifing noodle";
        flour = "common flour";
        soup = "clean soup";

        materialList.add("egg");
        materialList.add("tomato");
    }
}
