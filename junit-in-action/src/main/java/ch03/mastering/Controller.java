package ch03.mastering;

/**
 * A controller interface.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
public interface Controller {

    /**
     * process the request.
     *
     * @param request
     * @return
     */
    Response processRequest(Request request);

    /**
     * Add a request handler.
     *
     * @param request
     * @param requestHandler
     */
    void addHandler(Request request, RequestHandler requestHandler);
}
