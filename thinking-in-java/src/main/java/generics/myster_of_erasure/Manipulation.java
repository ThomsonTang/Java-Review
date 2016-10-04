package generics.myster_of_erasure;

/**
 * 因为擦除的原因，java编译器无法映射到{@code manipulate()} 方法必须能够调用{@code obj}的{@code f()}方法这个必需的条件。
 * 而存在的事实却是类{@link HasF}是拥有方法{@code f()}的。因此为了在代码中能够调用方法{@code f()}，我们通过给定一个边界限定来
 * 帮助泛型类让其告诉编译器仅仅接受那些符合该边界限定的类型。 这便是{@code extends}的另一用处。
 *
 * @author Thomson Tang
 */

class Manipulator<T extends HasF> {
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
        HasF hasF = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        manipulator.manipulate();
    }
}
