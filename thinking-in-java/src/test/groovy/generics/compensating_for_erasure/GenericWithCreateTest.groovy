package generics.compensating_for_erasure

import org.junit.Test

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-20:39
 */
class GenericWithCreateTest {
    @Test
    void testCreate() {
        Creator creator = new Creator();
        assert 'X' == creator.simpleName()
    }
}
