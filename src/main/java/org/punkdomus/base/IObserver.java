package org.punkdomus.base;

/**
 * Interface for observing algorithm state changes.
 * Classes implementing this interface can be notified when an algorithm updates its state.
 */
public interface IObserver {
    /**
     * Method to be called when the algorithm updates its state.
     */
    void update();
}
