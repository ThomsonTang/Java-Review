package effective.enumsandannotations.item33;

/**
 * Using ordinal() to index array of arrays. --- Don't do this.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/29/13
 */
public enum Phase {
    SOLID,
    LIQUID,
    GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // Rows indexed by src-ordinal, cols by dst-ordinal
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // Returns the phase transition from one phone to anther
        public static Transition from(Phase src, Phase dst) {
            return TRANSITIONS[src.ordinal()][dst.ordinal()];
        }
    }
}
