package generics;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */

class Manipulator<T extends HashF> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}


public class Manipulation {
    public static void main(String[] args) {
        HashF hashF = new HashF();
        Manipulator<HashF> manipulator = new Manipulator<>(hashF);
        manipulator.manipulate();
    }
}
