package org.com.sortAlgorithms;

import org.com.base.Algorithm;
import org.com.config.AlgorithmConfigs;
import org.com.ui.SortingGUI;

/**
 * The BubbleSort class is an implementation of the Bubble Sort algorithm, which is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
 *
 * @author Chavinho
 */
public class BubbleSort extends Algorithm {

    /**
     * Constructor for the BubbleSort class.
     *
     * @param algorithmConfigs The configuration settings for the algorithm.
     */
    public BubbleSort(AlgorithmConfigs algorithmConfigs) {
        super(algorithmConfigs);
    }

    /**
     * Sorts the elements using the Bubble Sort algorithm.
     * Prints the original list and the sorted list after execution.
     *
     * @param visualizer the sorting visualizer
     */
    @Override
    public void sort(SortingGUI visualizer) {
        this.visualizer = visualizer;
        bubbleSort();
    }

    /**
     * Implements the Bubble Sort algorithm.
     * Iteratively compares adjacent elements and swaps them if they are in the wrong order.
     */
    private void bubbleSort() {
        int n = elements.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (!compare(elements.get(j), elements.get(j + 1))) {
                    swap(j, j + 1);
                    swapped = true;
                }

                iterationCount++;
                notifyObserver();
                visualizer.updateArray(elements, j, j + 1);
            }

            if (!swapped) break;
        }
    }
}