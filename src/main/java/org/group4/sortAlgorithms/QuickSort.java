package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AppConfigs;


import java.util.List;


public class QuickSort extends Algorithm {

    /**
     * Constructor for the QuickSort class.
     *
     * @param elements List of elements to be sorted
     * @param typeOrder Type of order (numeric or alphabetic)
     * @param iterationTime Number of iterations for sorting
     * @param isNumeric Flag indicating whether the elements are numeric
     */
    public QuickSort(List<String> elements, String typeOrder, int iterationTime, boolean isNumeric) {
        super(elements, typeOrder, iterationTime, isNumeric);
    }

    /**
     * Sorts the elements using the QuickSort algorithm.
     * Prints the original list and the sorted list after execution.
     */
    public void sort() {
        displayOriginalList();
        quickSort(0, elements.size() - 1);
        displaySortedArray();
    }

    /**
     * Implements the main recursive logic of QuickSort.
     * Sorts the subarray between the low and high indexes.
     *
     * @param low Initial index of the subarray
     * @param high Final index of the subarray
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the subarray around a pivot.
     * Rearranges the elements so that all those smaller than the pivot are on the left,
     * and all the larger ones on the right.
     *
     * @param low Initial index of the subarray
     * @param high Final index of the subarray
     * @return Final index of the pivot after partitioning
     */
    private int partition(int low, int high) {
        String pivot = elements.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(elements.get(j), pivot)) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        displayCurrentState();
        return i + 1;
    }

    /**
     * Compares two elements considering whether they are numeric or not and the sorting direction.
     *
     * @param a First element for comparison
     * @param b Second element for comparison
     * @return true if 'a' should come before 'b' in the current ordering
     */
    private boolean compare(String a, String b) {
        if (isNumeric) {
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            return isAscending ? numA <= numB : numA > numB;
        }

        if (isAscending) {
            // para az
            return a.compareTo(b) < 0;
        }
        return a.compareTo(b) > 0;
    }

    /**
     * Swaps two positions in the array.
     *
     * @param i First position
     * @param j Second position
     */
    private void swap(int i, int j) {
        String temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
