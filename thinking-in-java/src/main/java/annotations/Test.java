package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The definition of the @Test annotation.
 * This give us an example how to define an annotation.
 *
 * This is a marker-annotation which which without any elements.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/2/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
