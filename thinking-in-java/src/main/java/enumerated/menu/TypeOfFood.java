package enumerated.menu;

import static enumerated.menu.Food.*;

/**
 * Using interfaces for organization.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
    }
}
