package org.com.sortAlgorithms;

import org.com.base.Algorithm;
import org.com.config.AlgorithmConfigs;
import org.com.ui.SortingGUI;


/**
 * The QuickSort class is an implementation of the QuickSort algorithm, which is a divide-and-conquer algorithm for sorting an array.
 *
 * @author maraya
 */
public class QuickSort extends Algorithm {

    /**
     * Constructs a new instance of the QuickSort class with the given algorithm configurations.
     *
     * @param algorithmConfigs the algorithm configurations
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
        quickSort(0, elements.size() - 1);
    }

    /**
     * Recursively applies the QuickSort algorithm to the given range of elements.
     *
     * @param low  the lower index of the range
     * @param high the higher index of the range
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);

            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        String pivot = elements.get(high);
        int i = low - 1;


        for (int j = low; j < high; j++) {
            iterationCount++;
            if (compare(elements.get(j), pivot)) {
                  i++;
                swap(i, j);
                notifyObserver();
                visualizer.updateArray(elements, i, j);
            }
        }
        swap(i + 1, high);
        notifyObserver();
        visualizer.updateArray(elements, i + 1, high); // Atualiza visualização após a troca do pivot

        return i + 1;
    }

}