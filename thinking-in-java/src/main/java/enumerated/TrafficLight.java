package enumerated;

import static net.mindview.util.Print.print;
import static enumerated.Signal.*;

/**
 * enums in switch statements.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */

//Define an enum type
enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {
    Signal color = RED;

    public void change() {
        switch (color) {
            //Don't have to say Signal.RED
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    public String toString() {
        return "the traffic light is " + color;
    }

    public static void main(String args[]) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }
}
