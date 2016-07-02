package threadmanagement;

/**
 * Force an exception try to convert a string value into an int value.
 *
 * @author ThomsonTang
 * @date 7/3/14
 */
public class Task implements Runnable {

    private String id;

    public Task(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        int i = Integer.parseInt(id);
        System.out.println("the id is: " + i);
    }
}
