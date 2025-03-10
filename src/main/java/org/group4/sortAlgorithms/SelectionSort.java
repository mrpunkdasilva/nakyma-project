package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;
import org.group4.ui.SortingGUI;

/**
 * The SelectionSort class is an implementation of the Selection Sort algorithm, which is a simple sorting algorithm that works by repeatedly finding the minimum element from the unsorted part of the array and swapping it with the first element of the unsorted part.
 */
public class SelectionSort extends Algorithm {

    /**
     * Constructs a new instance of the SelectionSort class with the given algorithm configurations.
     *
     * @param algorithmConfigs the algorithm configurations
     */
    public SelectionSort(AlgorithmConfigs algorithmConfigs) {
        super(algorithmConfigs);
    }

    /**
     * Sorts the elements using the Selection Sort algorithm.
     *
     * @param visualizer the sorting visualizer
     */
    @Override
    public void sort(SortingGUI visualizer) {
        setVisualizer(visualizer);
        selectionSort();
    }

    /**
     * Performs the Selection Sort algorithm on the elements.
     */
    private void selectionSort() {
        int totalElements = elements.size();

        for (int currentIndex = 0; currentIndex < totalElements - 1; currentIndex++) {
            int minIndex = currentIndex;

            for (int nextIndex = currentIndex + 1; nextIndex < totalElements; nextIndex++) {
                if (shouldSwap(minIndex, nextIndex)) {
                    minIndex = nextIndex;
                }
            }

            if (minIndex != currentIndex) {
                swap(currentIndex, minIndex);
                visualizer.updateArray(elements, currentIndex, minIndex);
            }

            iterationCount++;
            notifyObserver();
        }
    }

    /**
     * Determines whether the element at the candidate index should be swapped with the element at the current minimum index.
     *
     * @param currentMin the index of the current minimum element
     * @param candidate the index of the candidate element
     * @return true if the candidate element should be swapped with the current minimum element, false otherwise
     */
    private boolean shouldSwap(int currentMin, int candidate) {
        return !compare(elements.get(currentMin), elements.get(candidate));
    }
}