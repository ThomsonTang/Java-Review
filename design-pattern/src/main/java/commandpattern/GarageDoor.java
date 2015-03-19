package commandpattern;

/**
 * 车库门
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/16/13
 */
public class GarageDoor {

    public GarageDoor() {}

    void up() {
        System.out.println("the door is open.............");
    }

    void down() {
        System.out.println("the door is closed.............");
    }

    void lightOn() {
        System.out.println("light on.............");
    }

    void lightOff() {
        System.out.println("light off.............");
    }
}
