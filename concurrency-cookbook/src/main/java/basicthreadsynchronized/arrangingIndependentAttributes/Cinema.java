package basicthreadsynchronized.arrangingIndependentAttributes;

/**
 * This class simulates a cinema with two screens and two ticket offices. When a ticker office sells
 * tickets, they are for one of the two cinemas, but not for both, so the numbers of free seats in
 * each cinema are independent attributes.
 *
 * @author Thomson Tang
 * @version Created ：2016-8/9/16-17:36
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1, controlCinema2;

    public Cinema() {
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }
}
