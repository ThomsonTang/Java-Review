package corejava;

/**
 * @author Thomson Tang
 * @version Created ：2016-23/09/2016-14:47
 */
public enum SpursPlayers {
    TIM_DUNCAN(21, "tim duncan"),
    TONY_PARKER(9, "tony parker"),
    MANU_GINOBILI(20, "manu ginobili");

    private int number;
    private String name;

    SpursPlayers(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static SpursPlayers getByNumber(int number) {
        for (SpursPlayers player : SpursPlayers.values()) {
            if (player.number == number) {
                return player;
            }
        }
        return null;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
