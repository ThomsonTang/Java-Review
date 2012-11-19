package object;

/**
 * Created by IntelliJ IDEA.
 * User: ThomsonTang
 * Date: 8/6/12
 * Time: 10:21 AM
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
