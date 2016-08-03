package ch06.stubs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Web Client.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @version 6/5/14
 */
public class TestWebClient {
    @BeforeClass
    public static void setUp() throws Exception {
        Server server = new Server(8080);

        TestWebClient testWebClient = new TestWebClient();

        Context contentOkContext = new Context(server, "/testGetContentOk");
        contentOkContext.setHandler(testWebClient.new TestGetContentOkHandler());

        Context contentNotFoundContext = new Context(server, "testGetContentNotFound");
        contentNotFoundContext.setHandler(testWebClient.new TestGetContentNotFoundHandler());

        server.setStopAtShutdown(true);
        server.start();
    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentOk"));

        assertEquals("It works", result);
    }

    @Test
    public void testGetContentNotFound() throws MalformedURLException {
        WebClient client =  new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentNotFound"));

        assertNull(result);
    }

    @AfterClass
    public static void tearDown() {
        //empty
    }

    private class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {

            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();

            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    private class TestGetContentNotFoundHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
