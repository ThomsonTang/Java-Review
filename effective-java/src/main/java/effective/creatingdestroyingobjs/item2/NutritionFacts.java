package effective.creatingdestroyingobjs.item2;

/**
 * Builder Pattern
 * Consider a builder when faced with many constructor parameters.
 *
 * In summary, the Builder Pattern is a good choice when designing classes
 * whose constructors or static factories would have more than a handful of
 * parameters, especially if most of those parameters are optional.
 * Client code is much easier to read and write than with the traditional
 * telescoping constructor pattern, and builders are much safer than JavaBeans.
 *
 * @author Thomson Tang
 * @since 12-9-3
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //Required parameters
        private final int servingSize;
        private final int servings;

        //Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
