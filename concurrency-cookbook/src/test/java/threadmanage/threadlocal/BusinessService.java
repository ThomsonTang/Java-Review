package threadmanage.threadlocal;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-8/25/16-15:31
 */
public class BusinessService {
    private static BusinessService INSTANCE;

    private BusinessService() {
    }

    public static BusinessService getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new BusinessService();
        }
        return INSTANCE;
    }
}
