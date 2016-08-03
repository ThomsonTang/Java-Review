package enumerated;

import net.mindview.util.Generator;

import java.util.Random;

/**
 * Implements, not inherits.
 *
 * @author Thomson Tang
 * @version 6/3/13
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, BOB;

    private static Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }

//    static CartoonCharacter next() {
//        return values()[rand.nextInt(values().length)];
//    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ". ");
    }

    static public void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
