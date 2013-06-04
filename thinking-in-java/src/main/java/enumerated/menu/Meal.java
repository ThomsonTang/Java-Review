package enumerated.menu;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("----------");
        }
    }
}
