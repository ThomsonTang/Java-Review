package threadsafety;

import net.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * A Stateless Servlet.
 *
 * This is a simple factorization servlet. It unpacks the number to be factored from the servlet request, factors it,
 * and packages the results into the servlet response.
 *
 * {@link StatelessFactorizer} is, like most servlet, stateless: it has no fields and references no fields from other
 * classes. The transient state for a particular computation exists solely in local variables that are stored on the
 * thread's stack and are accessible only to the executing thread.
 *
 * One thread accessing a {@link StatelessFactorizer} cannot influence the result of another thread accessing the
 * same {@link StatelessFactorizer}; because the two threads do not share state, it is as if they were accessing
 * different instances.
 *
 * <strong>Stateless objects are always thread-safe.</strong>
 *
 * @author Thomson Tang
 * @version 8/5/13
 */
@ThreadSafe
public class StatelessFactorizer implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException,
            IOException {
        BigInteger i = exactFromRequest(servletRequest);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(servletResponse, factors);
    }

    private void encodeIntoResponse(ServletResponse servletResponse, BigInteger[] factors) {
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }

    private BigInteger exactFromRequest(ServletRequest servletRequest) {
        return new BigInteger("7");
    }

    @Override
    public String getServletInfo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
