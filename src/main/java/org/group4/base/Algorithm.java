package org.group4.base;

import org.group4.utils.Mercury;

import java.util.List;

/**
 * This is an abstract class representing an algorithm. It provides common attributes and methods for sorting algorithms.
 */
public abstract class Algorithm {

    /**
     * The list of strings to be sorted.
     */
    protected final List<String> list;

    /**
     * A flag indicating whether the sorting should be in ascending order.
     */
    protected final boolean isAscending;

    /**
     * The number of iterations the algorithm should perform.
     */
    protected final int iterationTime;

    /**
     * The current iteration count of the algorithm.
     */
    protected int iterationCount = 0;

    /**
     * An instance of the Mercury utility class.
     */
    protected Mercury mercury = new Mercury();


    /**
     * Constructor for the Algorithm class.
     *
     * @param list The list of strings to be sorted.
     * @param isAscending A flag indicating whether the sorting should be in ascending order.
     * @param iterationTime The number of iterations the algorithm should perform.
     */
    protected Algorithm(List<String> list, boolean isAscending, int iterationTime) {
        this.list = list;
        this.isAscending = isAscending;
        this.iterationTime = iterationTime;
    }

    /**
     * Displays the sorted list of strings.
     */
    public void displaySortedArray() {
        mercury.showMessage("Sorted List: " + list);
    }

    /**
     * Displays the current state of the algorithm, including the iteration count and the current list.
     */
    public void displayCurrentState() {
         mercury.showMessage("Iteration " + iterationCount + ": " + list);
    }
}