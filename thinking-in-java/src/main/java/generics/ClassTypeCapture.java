package generics;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
class Building {}

class House extends Building {}

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> building = new ClassTypeCapture<>(Building.class);
        System.out.println(building.f(new Building()));
        System.out.println(building.f(new House()));

        ClassTypeCapture<House> house = new ClassTypeCapture<>(House.class);
        System.out.println(house.f(new Building()));
        System.out.println(house.f(new House()));
    }
}
