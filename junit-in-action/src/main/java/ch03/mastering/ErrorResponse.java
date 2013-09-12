package ch03.mastering;

/**
 * Response that is returned in case of error.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
public class ErrorResponse implements Response {

    //original request.
    private Request originalRequest;

    //original exception.
    private Exception originalException;

    public ErrorResponse(Request request, Exception e) {
        this.originalRequest = request;
        this.originalException = e;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public void setOriginalRequest(Request originalRequest) {
        this.originalRequest = originalRequest;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    public void setOriginalException(Exception originalException) {
        this.originalException = originalException;
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
