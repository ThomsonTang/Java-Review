package enumerated;

import static net.mindview.util.Print.*;

/**
 * Add methods to an enum.
 *
 * Except for the fact that you can't inherit it, an enum can be treated much like a regular class.
 * The constructor can only be used to create the enum instances that you declare inside the enum definition;
 * the compiler won't let you use it to create any new instances once the enum definition is complete.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
public enum OzWitch {

    // Instances must be defined first, before methods.
    WEST("the west"),
    NORTH("the north"),
    EAST("the east"),
    SOUTH("the south"); // must end the sequence of enum instances with a semicolon.

    private String description;

    // Constructors must be package or private access.
    private OzWitch() {}
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main(String args[]) {
        for (OzWitch witch : OzWitch.values()) {
            print(witch + ": " + witch.getDescription());
        }
    }
}
