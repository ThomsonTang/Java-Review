package generics.wildcards;

import java.util.List;

/**
 * The argument {@code apples} is a {@link List} of some type that is the base type of {@link Apple}; thus you know
 * that it is safe to add an {@code Apple} or a subtype of {@code Apple}. Since the lower bound is {@code Apple},
 * however, you don't know that it is safe to add {@code Fruit} to such a {@code List}, because that would allow the
 * {@code List} to be opened up to the addition of non-Apple types, which would violate static type safety.
 *
 * @author Thomson Tang
 * @version Created ：2016-06/10/2016-20:44
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit()); // Error
    }
}
