package ch06.stubs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * To verify that WebClient works with a valid URL.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @version 5/22/14
 */
public class TestWebClientSkeleton {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        // Stop Jetty.
    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost:8080/testGetContentOk"));

        assertEquals("It works", result);
    }
}
