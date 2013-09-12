package ch03.mastering;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.image.SampleModel;

import static org.junit.Assert.*;

/**
 * Test-Case for default controller.
 * <p/>
 * As you create more tests like this, you'll notice that you follow a pattern:
 * <p/>
 * 1. Set up the test by placing the environment in a known stat (create objects, acquire resources). The pretest
 * state is referred to as the test fixture.
 * 2. Invoke the method under test.
 * 3. Confirm the result, usually by calling one or more assert methods.
 * <p/>
 *
 * JUnit Best Practices: Explain the failure reason in assert calls
 * Whenever you use any of the JUnit assert* methods, make sure you use the signature that takes a String as first
 * parameter which let you provide a meaningful description that's displayed in the JUnit test runner if the assert
 * fails.
 *
 * JUnit Best Practices: One unit test equals one @Test method
 * for best results, your test methods should be as concise and focused as your domain methods.
 *
 * JUnit Best Practices: Let the test improve the code
 * Writing unit tests often helps you write better code. The reason is simple: a test case is a user of your code.
 *
 * JUnit Best Practices: Make exception tests easy to read
 *
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
public class TestDefaultController {

//******************************* First Version ****************************************************
//    private DefaultController defaultController;
//
//    @Before
//    public void instantiate() throws Exception {
//        defaultController = new DefaultController();
//    }
//
//    public void testMethod() {
//        throw new RuntimeException("implement me");
//    }
//
//    private class SampleRequest implements Request {
//
//        @Override
//        public String getName() {
//            return "TEST";
//        }
//    }
//
//    private class SampleHandler implements RequestHandler {
//
//        @Override
//        public Response process(Request request) throws Exception {
//            return new SampleResponse();
//        }
//    }
//
//    private class SampleResponse implements Response {
//        //empty the response
//    }
//
//
//    @Test
//    public void testAddHandler() {
//        Request request = new SampleRequest();
//        RequestHandler requestHandler = new SampleHandler();
//        defaultController.addHandler(request, requestHandler);
//        RequestHandler requestHandler2 = defaultController.getHandler(request);
//        assertSame("Handler was set in controller should be the same handler we get", requestHandler, requestHandler2);
//    }
//
//    /**
//     * JUnit Best Practices: Explain the failure reason in assert calls
//     * Whenever you use any of the JUnit assert* methods, make sure you use the signature that takes a String as first
//     * parameter which let you provide a meaningful description that's displayed in the JUnit test runner if the assert
//     * fails.
//     *
//     */
//    @Test
//    public void testProcessRequest() {
//        Request request = new SampleRequest();
//        RequestHandler requestHandler = new SampleHandler();
//        defaultController.addHandler(request, requestHandler);
//        Response response = defaultController.processRequest(request);
//
//        assertNotNull("Must not return a null response:", response);
//        assertEquals("Response should be of type SampleResponse.", SampleResponse.class, response.getClass());
//    }
//************************************************************************************************************/


    //****************************** Second Version after Refactoring *******************************
    private DefaultController controller;
    private Request request;
    private RequestHandler requestHandler;

    @Before
    public void instantiate() {
        controller = new DefaultController();
        request = new SampleRequest();
        requestHandler = new SampleRequestHandler();

        controller.addHandler(request, requestHandler);
    }

    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Test";
        private String name;

        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        public SampleRequest(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    private class SampleResponse implements Response {
        private static final String NAME = "Test";

        public String getName() {
            return NAME;
        }

        public boolean equals(Object object) {
            boolean result = false;
            if (object instanceof SampleResponse) {
                result = ((SampleResponse)object).getName().equals(getName());
            }
            return result;
        }

        public int hashCode() {
            return NAME.hashCode();
        }
        // empty
    }

    private class SampleRequestHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    @Test
    public void testAddHandler() {
        RequestHandler requestHandler1 = controller.getHandler(request);
        assertSame("Must be as same", requestHandler1, requestHandler);
    }

    @Test
    public void testProcessRequest() {
        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response:", response);
        assertEquals("Response should be equals with name TEST.", new SampleResponse(), response);
    }

    private class SampleExceptionHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request.");
        }
    }

    @Test
    public void testProcessRequestAnswersErrorResponse() {
        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler= new SampleExceptionHandler();
        controller.addHandler(request, handler);
        Response response = controller.processRequest(request);

        assertNotNull("Must not return a null response:", response);
        assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest("testNotDefined");

        //this line is supposed to throw a RuntimeException.
        controller.getHandler(request);
    }

    @Test(timeout = 130)
    @Ignore(value = "Ignore for now until we decide a decent time-limit")
    public void testProcessMultipleRequestTimeout() {
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleRequestHandler();

        for (int i = 0; i < 99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);
            response = controller.processRequest(request);

            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }

}
