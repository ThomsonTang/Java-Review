package enumerated.menu;

import net.mindview.util.Enums;

/**
 * Creating a surrounding {@code enum} with one instance for each {@code enum}.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class);

    private Food[] values;

    private Course(Class<? extends Food>  kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
