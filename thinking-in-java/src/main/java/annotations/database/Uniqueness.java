package annotations.database;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/3/13
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
