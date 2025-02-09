package org.group4.sortAlgorithms;

import org.group4.base.Algorithm;
import org.group4.config.AppConfigs;


import java.util.List;


public class QuickSort extends Algorithm {

    /**
     * Builds a new QuickSort instance based on the settings provided.
     *
     * @param configs Application settings containing the input list and sort parameters
     * @throws NullPointerException if configs is null
     */

    public QuickSort(List<String> list, boolean isAscending, int iterationTime) {
        super(list, isAscending, iterationTime);
    }

    /**
     * Sorts the elements using the QuickSort algorithm.
     * Prints the original list and the sorted list after execution.
     */
    public void sort() {
        quickSort(0, list.size() - 1);
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
        printIteration();
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

        iterationCount++;
        displayCurrentState();
        if (isAscending) {
            // para az
            return a.compareTo(b) < 0;
        }
        return a.compareTo(b) > 0;
    }

    /**
     * Checks if a string represents an integer.
     *
     * @param str String to be checked
     * @return true if the string is a valid number, false otherwise
     */
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
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

    /**
     * Displays the current state of the list while the algorithm is running.
     * Pauses execution for iterationTime milliseconds.
     */
    private void printIteration() {
        System.out.println("Iteração: " + elements);
        try {
            Thread.sleep(iterationTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

        return i + 1;
    }

    private void swap(int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
