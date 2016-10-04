package generics.compensating_for_erasure;

/**
 * Another approach is the Template Method design pattern.
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-20:32
 */
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {

}

public class Creator extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }

    String simpleName() {
        return element.getClass().getSimpleName();
    }
}
