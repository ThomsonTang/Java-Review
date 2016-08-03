package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicate the database type integer.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/3/13
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}
