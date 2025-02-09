package org.group4.sortAlgorithms;

import org.group4.config.AppConfigs;
import java.util.List;

public class QuickSort {
    private List<String> elements;
    private final boolean isAscending;
    private final int iterationTime;
    private final boolean isNumeric;

    public QuickSort(AppConfigs configs) {
        this.isAscending = configs.o().equalsIgnoreCase("az");
        this.iterationTime = configs.s();
        this.elements = configs.inputList();
        this.isNumeric = elements.stream().allMatch(this::isNumeric);
//        System.out.println("Valores recebidos no QuickSort: " + elements);
    }

    public void sort() {
        System.out.println("Original list: " + elements);
        quickSort(0, elements.size() - 1);
        System.out.println("Sorted list: " + elements);
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
            if (compare(elements.get(j), pivot)) {
                i++;
                swap(i, j);

            }
        }
        swap(i + 1, high);
        printIteration();
        return i + 1;
    }

    private boolean compare(String a, String b) {
        if (isNumeric) {
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            return isAscending ? numA <= numB : numA > numB;
        }

        if (isAscending) {
            // para az
            if (a.toLowerCase().equalsIgnoreCase(b.toLowerCase())) {
                return a.compareTo(b) < 0;  // Maiúsculas antes de minúsculas
            }
            return a.toLowerCase().compareTo(b.toLowerCase()) < 0;
        } else {  // Para "za"
            return a.toLowerCase().compareTo(b.toLowerCase()) > 0;
        }
    }


    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private void swap(int i, int j) {
        String temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    private void printIteration() {
        System.out.println("Iteração: " + elements);
        try {
            Thread.sleep(iterationTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
