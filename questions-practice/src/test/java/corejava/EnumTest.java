package corejava;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-23/09/2016-14:59
 */
public class EnumTest {

    @Test
    public void testEquals() {
        SpursPlayers player = SpursPlayers.getByNumber(21);
        assertTrue(player == SpursPlayers.TIM_DUNCAN);
        assertTrue(player.equals(SpursPlayers.TIM_DUNCAN));
    }
}
