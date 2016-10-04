package generics.myster_of_erasure

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-17:59
 */
class ArrayMakerTest extends GroovyTestCase {
    void testCreate() {
        def stringMaker = new ArrayMaker<String>(String.class)
        def strings = stringMaker.create(9);
        println "the strings: "
        println strings;
    }

    void testIntegerMaker() {
        def integerMaker = new ArrayMaker<Integer>(Integer.class)
        def integers = integerMaker.create(2);
        assert "[null, null]" == integers.toArrayString()
        println "the integers: "
        println integers
        println integers.toArrayString()
    }
}
