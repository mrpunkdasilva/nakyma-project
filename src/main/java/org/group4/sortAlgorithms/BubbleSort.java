package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;

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
     */
    @Override
    public void sort() {
        displayOriginalList();
        bubbleSort();
        displaySortedArray();
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
                    notifyObserver();
                    swap(j, j + 1);
                    swapped = true;

                }

                iterationCount++;
            }

            if (!swapped) break;
        }
    }
}
