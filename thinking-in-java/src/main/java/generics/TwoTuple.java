package generics;

/**
 * 二元组，可以用来在方法中返回多个元素
 *
 * @author Thomson Tang
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return String.format("(%s,%s)", first, second);
    }
}
