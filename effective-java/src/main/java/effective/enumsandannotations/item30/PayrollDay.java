package effective.enumsandannotations.item30;

/**
 * Enum that switches on its value to share code - questionable
 *
 * A disadvantage of constant-specific method implementations is that they make it harder to share code among enum
 * constants.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/23/13
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int HOURS_PER_SHIFT = 8;

    double pay(double hoursWorked, double payRate) {
        double basePay = hoursWorked * payRate;
        double overtimePay;

        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overtimePay = hoursWorked * payRate / 2;
            default: // Weekdays
                overtimePay = hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
                break;
        }

        return basePay + overtimePay;
    }
}
