package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;

public class SelectionSort extends Algorithm {

    /**
     * Constructor for the SelectionSort class.
     *
     * @param algorithmConfigs Configuration settings for the algorithm.
     */
    public SelectionSort(AlgorithmConfigs algorithmConfigs) {
        super(algorithmConfigs);
    }

    /**
     * Sorts the elements using the Selection Sort algorithm.
     * Prints the original list and the sorted list after execution.
     */
    @Override
    public void sort() {
        displayOriginalList();
        selectionSort();
        displaySortedArray();
    }

    /**
     * Implements the Selection Sort algorithm.
     * Finds the smallest element and swaps it with the first unsorted position.
     */
    private void selectionSort() {
        int n = elements.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (!compare(elements.get(minIndex), elements.get(j))) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(i, minIndex);
            }

            iterationCount++;
            displayCurrentState();
        }
    }
}
