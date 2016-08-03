package ch03.mastering;

/**
 * The request handler interface.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 5/31/13
 */
public interface RequestHandler {

    /**
     * Process the request.
     *
     * @param request
     * @return response Response
     * @throws Exception
     */
    Response process(Request request) throws Exception;
}
