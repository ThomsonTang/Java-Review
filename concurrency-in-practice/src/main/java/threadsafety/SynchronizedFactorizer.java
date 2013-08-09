package threadsafety;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/5/13
 */
@ThreadSafe
public class SynchronizedFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        if (i.equals(lastNumber))
            encodeIntoResponse(servletResponse, lastFactors);
        else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(servletResponse, factors);
        }
    }

    private void encodeIntoResponse(ServletResponse servletResponse, BigInteger[] factors) {
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }

    private BigInteger extractFromRequest(ServletRequest servletRequest) {
        return new BigInteger("7");
    }
}
