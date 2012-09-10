package object;

/**
 * Created by IntelliJ IDEA.
 * User: tangguike
 * Date: 8/6/12
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(null == singleton){
            singleton = new Singleton();
        }
        return singleton;
    }
}
