package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;
import org.group4.ui.SortingGUI;

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
    public void sort(SortingGUI visualizer) {
        this.visualizer = visualizer;
        selectionSort();
    }

    /**
     * Implements the Selection Sort algorithm.
     * Finds the smallest element and swaps it with the first unsorted position.
     */
    private void selectionSort() {
        int totalElements = elements.size();

        for (int currentIndex = 0; currentIndex < totalElements - 1; currentIndex++) {
            int minIndex = currentIndex;

            for (int nextIndex = currentIndex + 1; nextIndex < totalElements; nextIndex++) {
                if (!compare(elements.get(minIndex), elements.get(nextIndex))) {
                    minIndex = nextIndex;
                }
                notifyObserver();
            }

            if (minIndex != currentIndex) {
                swap(currentIndex, minIndex);
                visualizer.updateArray(elements, currentIndex, minIndex);
            }

            iterationCount++;
            notifyObserver();
        }
    }
}
