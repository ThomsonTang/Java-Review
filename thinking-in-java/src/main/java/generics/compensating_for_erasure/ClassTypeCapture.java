package generics.compensating_for_erasure;

/**
 * capture the class type of an object
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-21:59
 */
public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean isInstance(Object arg) {
        return kind.isInstance(arg);
    }
}
