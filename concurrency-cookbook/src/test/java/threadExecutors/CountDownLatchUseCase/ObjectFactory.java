package threadExecutors.CountDownLatchUseCase;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/25/16-11:31
 */
public class ObjectFactory {

    private static volatile MyObject object;

    public static MyObject getInstance() {
        if (object == null) {
            synchronized (ObjectFactory.class) {
                if (object == null) {
                    object = new MyObject();
                }
            }
        }
        return object;
    }
}
