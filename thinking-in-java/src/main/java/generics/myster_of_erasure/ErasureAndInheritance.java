package generics.myster_of_erasure;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-02/10/2016-20:25
 */

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

class Derived2 extends GenericBase {
}

//class Derived3 extends GenericBase<?> {}

@SuppressWarnings("unchecked")
public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived1<String> d1 = new Derived1<String>();
        String s = d1.get();
        d1.set(s);

        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj); // warning here
    }
}
