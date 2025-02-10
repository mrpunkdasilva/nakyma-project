package org.group4.base;

import org.group4.config.AlgorithmConfigs;
import org.group4.utils.Mercury;
import org.group4.values.AsciiColor;

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
     */
    protected Algorithm(AlgorithmConfigs algorithmConfigs) {
        this.elements = algorithmConfigs.elements();
        this.isAscending = algorithmConfigs.typeOrder().equalsIgnoreCase("az");
        this.iterationTime = algorithmConfigs.skip();
        this.isNumeric = algorithmConfigs.isNumeric();
    }

    public abstract void sort();

    /**
     * Displays the sorted elements of strings.
     */
    protected void displaySortedArray() {
        mercury.showMessage("\nSorted List: " + elements);
    }

    /**
     * Displays the current state of the algorithm, including the iteration count and the current elements.
     */
    protected void displayCurrentState() {
        mercury.showMessage(
                AsciiColor.applyMultiple("ᓚᘏᗢ ", AsciiColor.YELLOW).repeat(iterationCount) + "\n"  +
                        "Iteration " + ": " + elements +
                        "\n"
        );
        try {
            Thread.sleep(iterationTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Compares two elements considering whether they are numeric or not and the sorting direction.
     *
     * @param a First element for comparison
     * @param b Second element for comparison
     * @return true if 'a' should come before 'b' in the current ordering
     */
    protected boolean compare(String a, String b) {
        if (isNumeric) {
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            return isAscending ? numA <= numB : numA > numB;
        }

        if (isAscending) return a.compareTo(b) < 0;

        return a.compareTo(b) > 0;
    }

    /**
     * Swaps two positions in the array.
     *
     * @param i First position
     * @param j Second position
     */
    protected void swap(int i, int j) {
        String temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    /**
     * Displays the original list of strings before sorting.
     *
     * @return void - This method does not return any value. It only displays the original elements.
     */
    protected void displayOriginalList() {
        mercury.showMessage("Original elements: " + elements + "\n");
    }
}