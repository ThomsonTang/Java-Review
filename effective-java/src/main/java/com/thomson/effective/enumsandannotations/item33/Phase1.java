package com.thomson.effective.enumsandannotations.item33;

import java.util.EnumMap;
import java.util.Map;

/**
 * Using a nested EnumMap to associate data with enum pairs.
 *
 * In summary, it is rarely appropriate to use ordinal to index arrays: use EnumMap instead.
 * If the relationship that you are representing is multidimensional, use EnumMap<..., EnumMap<...>>.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/30/13
 */
public enum Phase1 {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID);

        final Phase1 src;
        final Phase1 dst;

        Transition(Phase1 src, Phase1 dst) {
            this.src = src;
            this.dst = dst;
        }

        // Initialize the phase transition map
        private static final Map<Phase1, Map<Phase1, Transition>> m = new EnumMap<Phase1, Map<Phase1, Transition>>(Phase1.class);

        static {
            for (Phase1 p : Phase1.values())
                m.put(p, new EnumMap<Phase1, Transition>(Phase1.class));
            for (Transition transition : Transition.values())
                m.get(transition.src).put(transition.dst, transition);
        }

        public static Transition from(Phase1 src, Phase1 dst) {
            return m.get(src).get(dst);
        }
    }
}
