package org.com.ui;

import org.com.base.Algorithm;
import org.com.base.IObserver;

/**
 * Observer class that listens for algorithm updates and prints the current state.
 */
public class SortingObserver implements IObserver {
    private final Algorithm algorithm;

    /**
     * Constructs a SortingObserver that listens to a given algorithm.
     *
     * @param algorithm The algorithm instance to observe.
     */
    public SortingObserver(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Called when the observed algorithm updates its state.
     * Triggers the display of the current state.
     */
    @Override
    public void update() {
        algorithm.displayCurrentState();
    }
}
