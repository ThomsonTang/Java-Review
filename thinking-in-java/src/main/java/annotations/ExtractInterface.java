package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Here is an annotation that can be used to extract the public methods
 * from a class and turn them into an interface.
 *
 * The RetentionPolicy is SOURCE because there is no point in keeping this
 * annotation in the class file after we have extracted the interface from
 * the class.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/4/13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    public String value();
}
