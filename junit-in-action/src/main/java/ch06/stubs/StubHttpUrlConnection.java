package ch06.stubs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Stubbed HttpUrlConnection class.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 6/6/14
 */
public class StubHttpUrlConnection extends HttpURLConnection {
    private boolean isInput = true;

    public StubHttpUrlConnection(URL url) {
        super(url);
    }

    public InputStream getInputStream() throws ProtocolException {
        if (!isInput) {
            throw new ProtocolException("Can not read from URLConnection if doInput=false");
        }

        ByteArrayInputStream bais = new ByteArrayInputStream("It works".getBytes());
        return bais;
    }

    @Override
    public void connect() throws IOException {}
    public void disconnect() {}
    public boolean usingProxy() {
        return false;
    }
}
