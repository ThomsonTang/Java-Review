package commandpattern;

/**
 * 卧室的灯, 实现了灯的统一接口Light
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/16/13
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
