package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that tracks use cases in a project.
 *
 * Allowed types for annotation elements:
 *  <ul>
 *      <li>All primitives</li>
 *      <li>String</li>
 *      <li>Class</li>
 *      <li>Enums</li>
 *      <li>Annotations</li>
 *      <li>Arrays of any of the above</li>
 *  </ul>
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/2/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {
    public int id();

    public String description() default "no description";
}
