package enumerated.menu;

/**
 * Using interfaces for organization.
 * Subcategorization of enums within interfaces.
 *
 * @author Thomson Tang
 * @date 6/3/13
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAi;
    }
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE;
    }
}
