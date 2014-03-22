package standardlib;

/**
 * An abstract data type for a Stopwatch.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 12/20/13
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
