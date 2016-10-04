package generics.compensating_for_erasure;

/**
 * use an explicit factory and constrain the type so that it only takes a class that implements this factory.
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-23:14
 */
public interface FactoryI<T> {
    T create();
}

class Foo<T> {
    private T t;

    public <F extends FactoryI<T>> Foo(F factory) {
        t = factory.create();
    }

    public T get() {
        return t;
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
