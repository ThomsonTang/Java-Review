package generics.compensating_for_erasure;

/**
 * 通过{@link Class}类的{@link Class#newInstance()}方法来创建泛型类型的对象
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-22:43
 */
public class ClassAsFactory<T> {
    T instance;

    public ClassAsFactory(Class<T> t) {
        try {
            this.instance = t.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
