package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AppConfigs;
import org.group4.utils.Mercury;

import java.util.List;


public class QuickSort extends Algorithm {

//    /**
//     * QuickSort constructor.
//     *
//     * @param list List to be sorted.
//     * @param isAscending Defines whether the sort will be ascending or descending.
//     * @param iterationTime Pause time between each iteration, in milliseconds.
//     */

    public QuickSort(List<String> list, boolean isAscending, int iterationTime) {
        super(list, isAscending, iterationTime);
    }

    /**
     * Public method to start sorting.
     */
    public void sort() {
        quickSort(0, list.size() - 1);
    }

    /**
     * Implementation of the QuickSort algorithm.
     *
     * @param low Lower index.
     * @param high Upper index.
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    /**
     * Method to split the list and organize the elements in relation to the pivot.
     *
     * @param low Initial index of the partition.
     * @param high Final index of the split.
     * @return The index of the pivot after the split.
     */
    private int partition(int low, int high) {
        String pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // If ascending (az), sort from smallest to largest
            // If decreasing (za), sort from largest to smallest
            if ((isAscending && list.get(j).compareTo(pivot) <= 0) ||
                    (!isAscending && list.get(j).compareTo(pivot) >= 0)) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);

        iterationCount++;
        displayCurrentState();

        try {
            Thread.sleep(iterationTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return i + 1;
    }

    private void swap(int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
