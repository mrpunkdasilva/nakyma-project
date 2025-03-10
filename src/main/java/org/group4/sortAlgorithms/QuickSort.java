package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;
import org.group4.ui.SortingGUI;

/**
 * QuickSort implementation with proper partitioning and recursive sorting.
 */
public class QuickSort extends Algorithm {

    /**
     * Constructor for QuickSort.
     *
     * @param algorithmConfigs Configuration for the sorting algorithm
     */
    public QuickSort(AlgorithmConfigs algorithmConfigs) {
        super(algorithmConfigs);
    }

    /**
     * Sorts the elements using the QuickSort algorithm.
     *
     * @param visualizer the sorting visualizer
     */
    @Override
    public void sort(SortingGUI visualizer) {
        this.visualizer = visualizer;
        if (elements == null || elements.isEmpty()) {
            return;
        }
        quickSort(0, elements.size() - 1);
    }

    /**
     * Recursive QuickSort function.
     *
     * @param low  Starting index
     * @param high Ending index
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = medianOfThree(low, high);
            swap(pivotIndex, high);
            pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot element and returns its final position.
     *
     * @param low  Starting index
     * @param high Ending index
     * @return The final pivot position
     */
    private int partition(int low, int high) {
        String pivot = elements.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            iterationCount++;
            if (compare(elements.get(j), pivot)) {
                i++;
                if (i != j) {
                    swap(i, j);
                    notifyObserver();
                    visualizer.updateArray(elements, i, j);
                }
            }
        }

        swap(i + 1, high);
        notifyObserver();
        visualizer.updateArray(elements, i + 1, high);
        return i + 1;
    }

    /**
     * Selects the pivot using the median-of-three method.
     *
     * @param low the lower index of the range
     * @param high the higher index of the range
     * @return the index of the median element
     */
    private int medianOfThree(int low, int high) {
        int mid = low + (high - low) / 2;
        String a = elements.get(low);
        String b = elements.get(mid);
        String c = elements.get(high);

        if ((a.compareTo(b) < 0 && b.compareTo(c) < 0) || (c.compareTo(b) < 0 && b.compareTo(a) < 0)) {
            return mid;
        } else if ((b.compareTo(a) < 0 && a.compareTo(c) < 0) || (c.compareTo(a) < 0 && a.compareTo(b) < 0)) {
            return low;
        } else {
            return high;
        }
    }
}