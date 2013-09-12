package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/3/13
 */
@Target(ElementType.TYPE) // Applies to classes only.
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
