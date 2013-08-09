package threadsafety;

import net.jcip.annotations.GuardedBy;

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
public class CachedFactorizer {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;


    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
        encodeIntoResponse(servletResponse, lastFactors);
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
