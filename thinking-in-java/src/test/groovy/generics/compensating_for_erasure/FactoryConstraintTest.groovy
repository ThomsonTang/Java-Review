package generics.compensating_for_erasure

import org.junit.Test

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-16:41
 */
class FactoryConstraintTest  {

    @Test
    void testCreate() {
        def foo = new Foo<Integer>(new IntegerFactory())
        assert 0 == foo.get()
        def widgetFoo = new Foo<Widget>(new Widget.Factory())
        assert widgetFoo.get() instanceof Widget
    }
}
