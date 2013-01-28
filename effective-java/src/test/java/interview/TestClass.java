package interview;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @since 1.0-SNAPSHOT
 */
public class TestClass extends ParentClass {
    public static void main(String... args) {
        try {
            System.out.println("one");
            Integer i = null;
            i.toString();
        } catch (Exception e) {
            System.out.println("two");
            try {
                Integer i = null;
                i.toString();
            } catch (Exception e1) {
                System.out.println("three");
                Integer i = null;
                i.toString();
            }
        } finally {
            System.out.println("four");
        }
    }
}

class ParentClass {
    public enum numbers {one, two, three}
}
