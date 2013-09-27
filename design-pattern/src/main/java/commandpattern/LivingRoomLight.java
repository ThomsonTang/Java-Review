package commandpattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/16/13
 */
public class LivingRoomLight implements Light {

    @Override
    public void on() {
        System.out.println("turn on...............");
    }

    @Override
    public void off() {
        System.out.println("turn off...............");
    }
}
