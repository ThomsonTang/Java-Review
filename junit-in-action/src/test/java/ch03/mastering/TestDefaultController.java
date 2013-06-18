package ch03.mastering;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

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

    public void testMethod() {
        throw new RuntimeException("implement me");
    }

    private class SampleRequest implements Request {

        @Override
        public String getName() {
            return "TEST";
        }
    }

    private class SampleHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
        //empty the response
    }

    @Test
    public void testAddHandler() {
        Request request = new SampleRequest();
        RequestHandler requestHandler = new SampleHandler();
        defaultController.addHandler(request, requestHandler);
        RequestHandler requestHandler2 = defaultController.getHandler(request);
        assertSame("Handler was set in controller should be the same handler we get", requestHandler, requestHandler2);
    }
}
