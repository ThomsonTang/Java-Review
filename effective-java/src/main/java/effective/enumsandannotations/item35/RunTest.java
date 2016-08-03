package effective.enumsandannotations.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/11/13
 */
public class RunTest {
//    public static void main(String[] args) throws Exception{
//        int tests = 0;
//        int passed = 0;
//
//        Class testClass = Class.forName(args[0]);
//        for (Method m :testClass.getDeclaredMethods()) {
//            if (m.isAnnotationPresent(Test.class)) {
//                tests++;
//                try {
//                    m.invoke(null);
//                    passed++;
//                } catch (InvocationTargetException e) {
//                    Throwable exc = e.getCause();
//                    System.out.println(m + " failed: " + exc);
//                } catch (Exception ex) {
//                    System.out.println("INVALID @Test: " + m);
//                }
//            }
//        }
//
//        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
//    }

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception> exeType = m.getAnnotation(ExceptionTest.class).value();
                    if (exeType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, exeType.getName(), exc);
                    }
                } catch (Exception e) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
    }
}
