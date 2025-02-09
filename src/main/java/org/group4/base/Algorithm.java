package org.group4.base;

import org.group4.utils.Mercury;

import java.util.List;

/**
 * This is an abstract class representing an algorithm. It provides common attributes and methods for sorting algorithms.
 */
public abstract class Algorithm {

    /**
     * The elements of strings to be sorted.
     */
    protected List<String> elements;

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

    protected final boolean isNumeric;

    
    /**
     * Constructs an instance of the Algorithm class.
     *
     * @param elements The list of strings to be sorted.
     * @param typeOrder The order of sorting. It can be either "az" (for ascending) or "za" (for descending).
     * @param iterationTime The time interval in milliseconds between each iteration of the algorithm.
     * @param isNumeric A flag indicating whether the sorting should be performed numerically.
     */
    protected Algorithm(List<String> elements, String typeOrder, int iterationTime, boolean isNumeric) {
        this.elements = elements;
        this.isAscending = typeOrder.equalsIgnoreCase("az");
        this.iterationTime = iterationTime;
        this.isNumeric = isNumeric;
    }

    /**
     * Displays the sorted elements of strings.
     */
    protected void displaySortedArray() {
        mercury.showMessage("Sorted List: " + elements);
    }

    /**
     * Displays the current state of the algorithm, including the iteration count and the current elements.
     */
    protected void displayCurrentState() {
        mercury.showMessage("Iteration " + iterationCount + ": " + elements);
        try {
            Thread.sleep(iterationTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Displays the original list of strings before sorting.
     *
     * @return void - This method does not return any value. It only displays the original elements.
     */
    protected void displayOriginalList() {
        mercury.showMessage("Original elements: " + elements);
    }
}