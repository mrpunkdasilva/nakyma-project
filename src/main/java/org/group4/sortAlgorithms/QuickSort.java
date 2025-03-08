package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;
import org.group4.ui.SortingGUI;

import java.util.List;

public class QuickSort extends Algorithm {

    public QuickSort(AlgorithmConfigs algorithmConfigs) {
        super(algorithmConfigs);
    }

    @Override
    public void sort(SortingGUI visualizer) {
        this.visualizer = visualizer;
        for (int i = 0; i < 1; i++) {
            quickSort(0, elements.size() - 1);
        }
    }

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
                visualizer.updateArray(elements, i, j + 1);
            }
        }

        swap(i + 1, high);
        notifyObserver();
        return i + 1;
    }

}