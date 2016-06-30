package threadmanagement;

/**
 * Force an exception
 * try to convert a string value into an int value.
 *
 * @author ThomsonTang
 * @date 7/3/14
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int numero = Integer.parseInt("TTT");
    }
}
