package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AlgorithmConfigs;
import org.group4.ui.SortingGUI;

public class SelectionSort extends Algorithm {

    public SelectionSort(AlgorithmConfigs algorithmConfigs) {
        super(algorithmConfigs);
    }

    @Override
    public void sort(SortingGUI visualizer) {
        setVisualizer(visualizer);
        selectionSort();
    }

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

    private boolean shouldSwap(int currentMin, int candidate) {
        return !compare(elements.get(currentMin), elements.get(candidate));
    }
}