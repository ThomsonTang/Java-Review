package generics.myster_of_erasure

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-19:36
 */
class ListMakerTest {

    @Test
    void testCreateStrings() {
        def listMaker = new ListMaker<String>()
        assert [] == listMaker.create()
        println listMaker.create()
    }

    @Test
    void testCreateFilledStrings() {
        def listMaker = new ListMaker<>();
        def strings = listMaker.create("hello", 2);
        println strings
        assert ["hello", "hello"] == strings
    }
}
