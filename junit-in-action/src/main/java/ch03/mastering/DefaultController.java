package ch03.mastering;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
public class DefaultController implements Controller {

    private Map<String, RequestHandler> requestHandlers = new HashMap<String, RequestHandler>();

    protected RequestHandler getHandler(Request request) {
        if (!this.requestHandlers.containsKey(request.getName())) {
            String message = "can not find handler for request name " + "["
                    + request.getName() + "]";
            throw new RuntimeException(message);
        }
        return this.requestHandlers.get(request.getName());
    }

    @Override
    public Response processRequest(Request request) {
        Response response;
        try {
            response = this.getHandler(request).process(request);
        } catch (Exception e) {
            response = new ErrorResponse(request, e);
        }

        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has already been registered for request name [" + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }
}
