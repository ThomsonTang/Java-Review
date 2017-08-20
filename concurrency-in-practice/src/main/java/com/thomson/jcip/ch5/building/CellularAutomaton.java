package com.thomson.jcip.ch5.building;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Coordinating Computation in a Cellular Automaton with {@link CyclicBarrier}
 *
 * @author Thomson Tang
 * @version Created: 20/08/2017.
 */
public class CellularAutomaton {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomaton(Board mainBoard) {
        this.mainBoard = mainBoard;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
        });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }

    class Board {
        private int maxX;
        private int maxY;

        public void commitNewValues() {

        }

        public Board getSubBoard(int count, int i) {
            return null;
        }

        public boolean hasConverged() {
            return false;
        }

        public int getMaxX() {
            return maxX;
        }

        public int getMaxY() {
            return maxY;
        }

        public void waitForConvergence() {

        }

        public void setNewValue(int x, int y, int z) {
            this.maxX = x;
            this.maxY = y;
        }
    }

    class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()) {
                for (int i = 0; i < board.getMaxX(); i++) {
                    for (int j = 0; j < board.getMaxY(); j++) {
                        board.setNewValue(i, j, computeValue(i, j));
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }

        int computeValue(int x, int y) {
            return x + y;
        }
    }

    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();
    }
}
