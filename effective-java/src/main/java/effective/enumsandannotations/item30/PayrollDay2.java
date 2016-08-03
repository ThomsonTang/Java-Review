package effective.enumsandannotations.item30;

/**
 * The strategy enum pattern.
 * <p/>
 * The idea is to move the overtime pay computation onto a private nested enum, and to pass an instance of this strategy
 * enum to the constructor for the PayrollDay enum. The PayrollDay enum then delegates the overtime pay calculation to
 * the strategy enum, eliminating the need for a switch statement or constant-specific method implementation in PayrollDay.
 * While this pattern is less concise than the switch statement, it is safer and more flexible.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/23/13
 */
public enum PayrollDay2 {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay2(PayType payType) {
        this.payType = payType;
    }

    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    // The strategy enum type
    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs <= HOURS_PER_SHIFT ? 0 : (hrs - HOURS_PER_SHIFT) * payRate / 2;
            }
        },

        WEEKEND {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs * payRate / 2;
            }
        };

        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
