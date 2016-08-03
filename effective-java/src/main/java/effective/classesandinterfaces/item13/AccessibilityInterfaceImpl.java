package effective.classesandinterfaces.item13;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/1/13
 */
public class AccessibilityInterfaceImpl implements AccessibilityInterface {
    @Override
    public void defaultAccess() {
        System.out.print("test");
    }
}
