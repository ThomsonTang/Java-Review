package generics.compensating_for_erasure

import org.junit.Test

/**
 * 此处{@code isInstance()}的作用类似于{@code instanceof}，只不过含义恰好是相反的
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-22:14
 */
class Building {}

class Home extends Building {}

class ClassTypeCaptureTest {
    @Test
    void testIsInstance() {
        ClassTypeCapture<Building> building = new ClassTypeCapture<>(Building.class)
        assert building.isInstance(new Building())
        assert building.isInstance(new Home())

        ClassTypeCapture<Home> home = new ClassTypeCapture<>(Home.class)
        assert !home.isInstance(new Building())
        assert home.isInstance(new Home())
    }
}
