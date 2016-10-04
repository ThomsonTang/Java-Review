package generics.compensating_for_erasure

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

/**
 * 泛型的实例化操作
 *
 * 实例化{@link Integer}泛型失败，是因为{@link Integer}类没有默认的无参构造方法。
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-22:47
 */
class Employee {}

class InstantiateGenericTypeTest {

    @Test
    void testNewInstance() {
        ClassAsFactory<Employee> employeeFactory = new ClassAsFactory<>(Employee.class)
        assert employeeFactory.instance instanceof Employee
        println 'ClassAsFactory<Employee> succeeded'

        def fail = shouldFail {
            ClassAsFactory<Integer> integer = new ClassAsFactory<>(Integer.class)
        }

        println fail.message
    }
}
