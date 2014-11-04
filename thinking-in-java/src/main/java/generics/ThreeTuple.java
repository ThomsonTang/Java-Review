package generics;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;
    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return String.format("(%s, %s, %s)", first, second, third);
    }
}
