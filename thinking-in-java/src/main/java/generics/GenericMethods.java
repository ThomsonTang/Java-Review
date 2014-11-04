package generics;

/**
 * Generic Method.
 *
 * To define a generic method, you simply place a generic parameter list
 * before the return value.
 *
 * @author Thomson Tang
 */

class GenericClass<T> {
}

public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);

        GenericClass obj = new GenericClass();
    }
}
