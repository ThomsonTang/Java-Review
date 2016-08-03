package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Elements must either have default values or values provided by the class that uses the annotation.
 * There is another restriction, which is that none of the non-primitive type elements are allowed to
 * take null as a value, either when declared in source code or when defined as a default value in the
 * annotation interface.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/3/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    public int id() default -1;

    public String description() default "";
}
