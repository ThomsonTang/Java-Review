package generics.myster_of_erasure;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-20:34
 */
public class SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

}
