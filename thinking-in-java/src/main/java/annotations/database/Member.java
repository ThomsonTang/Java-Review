package annotations.database;

/**
 * A simple bean that use database annotations.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 9/3/13
 */
@DBTable(name = "MEMBER")
public class Member {
    @SqlString(30) String firstName;
    @SqlString(50) String lastName;
    @SqlInteger Integer age;

    @SqlString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public String toString() {
        return handle;
    }
}
