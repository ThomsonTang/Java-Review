package utils;

import generics.BasicGenerator;
import generics.CountedObject;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {

        Generator<CountedObject> generator = BasicGenerator.create(CountedObject.class);

        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }
}
