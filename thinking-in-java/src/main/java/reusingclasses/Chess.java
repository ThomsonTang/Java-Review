package reusingclasses;

import static net.mindview.util.Print.print;

/**
 * Constructors with arguments.
 * if there is no default constructor in base-class, or if you want to call a base-class constructor that has
 * arguments, you must explicitly use super keyword to call the base-class constructor with appropriate argument
 * list.
 *
 * @author Thomson Tang
 * @version 10/11/13
 */
class Game {
    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(10);
        print("Chess constructor");
    }
}
