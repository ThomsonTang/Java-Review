package ch06.stubs;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.*;

import static org.junit.Assert.assertEquals;

/**
 * Providing custom stream handler classes for testing.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 6/6/14
 */
public class TestWebClient1 {
    @BeforeClass
    public static void setUp() {
        TestWebClient1 client1 = new TestWebClient1();
        URL.setURLStreamHandlerFactory(client1.new StubStreamHandlerFactory());
    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost"));

        assertEquals("It works", result);
    }

    private class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StubHttpUrlConnection(url);
        }
    }
}
