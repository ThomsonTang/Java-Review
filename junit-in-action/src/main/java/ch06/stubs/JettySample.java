package ch06.stubs;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * Starting jetty in embedded mode.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @version 5/19/14
 */
public class JettySample {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        Context root = new Context(server, "/");
        root.setResourceBase("jetty-test.html");
        root.setHandler(new ResourceHandler());

        server.start();
    }
}
