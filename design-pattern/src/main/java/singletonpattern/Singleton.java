package singletonpattern;

/**
 * 单例模式
 *
 * @author Thomson Tang
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
