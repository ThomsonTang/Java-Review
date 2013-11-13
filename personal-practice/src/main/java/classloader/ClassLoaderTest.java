package classloader;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 10/31/13
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("ClassLoaderTest.getClass().getClassLoader(): " + ClassLoaderTest.class.getClassLoader());

        try {
            Class.forName("classloader.ClassLoaderTest", true, ClassLoader.class.getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
