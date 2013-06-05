package ch03.mastering;

import org.junit.Before;
import org.junit.Test;

/**
 * Test-Case for default controller.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
public class TestDefaultController {

    private DefaultController defaultController;

    @Before
    public void instantiate() throws Exception {
        defaultController = new DefaultController();
    }

    @Test
    public void testMethod() {
        throw new RuntimeException("implement me");
    }
}
