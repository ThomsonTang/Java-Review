package enumerated.menu;

import net.mindview.util.Enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 6/5/13
 */
enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHOT, LONG, MARGIN
        }
        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
       return Enums.random(values);
    }

    public static void main(String[] args) {
       for (int i = 0; i < 10; i++) {
           SecurityCategory category = Enums.random(SecurityCategory.class);
           System.out.println(category + " : " + category.randomSelection());
       }
    }
}
