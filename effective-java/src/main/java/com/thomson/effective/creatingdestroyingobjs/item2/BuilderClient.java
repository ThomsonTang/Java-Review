package com.thomson.effective.creatingdestroyingobjs.item2;

/**
 * Client code for using Builder Pattern.
 *
 * @author Thomson Tang
 * @since 1.0-SNAPSHOT
 */
public class BuilderClient {

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).build();
        NutritionFacts cocaCola2 = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    }
}
