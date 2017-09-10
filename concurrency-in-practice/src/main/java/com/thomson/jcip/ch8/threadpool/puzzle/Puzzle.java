package com.thomson.jcip.ch8.threadpool.puzzle;

import java.util.Set;

/**
 * 谜题对象的抽象类。
 *
 * @author Thomson Tang
 * @version Created: 10/09/2017.
 */
public interface Puzzle<P, M> {
    P initialPosition();

    boolean isGod(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
