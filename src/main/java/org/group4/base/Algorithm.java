package org.group4.base;

import org.group4.config.AlgorithmConfigs;
import org.group4.utils.Mercury;
import org.group4.values.AsciiColor;

import java.util.Collections;
import java.util.List;

/**
 * This is an abstract class representing an algorithm. It provides common attributes and methods for sorting algorithms.
 */
public abstract class Algorithm {

    /**
     * The elements of strings to be sorted.
     */
    protected List<String> elements;

    /**
     * A flag indicating whether the sorting should be in ascending order.
     */
    protected final boolean isAscending;

    /**
     * The number of iterations the algorithm should perform.
     */
    protected final int iterationTime;

    /**
     * The current iteration count of the algorithm.
     */
    protected int iterationCount = 0;

    /**
     * An instance of the Mercury utility class.
     */
    protected Mercury mercury = new Mercury();

    protected final boolean isNumeric;

    
    /**
     * Constructs an instance of the Algorithm class.
     */
    protected Algorithm(AlgorithmConfigs algorithmConfigs) {
        this.elements = algorithmConfigs.elements();
        this.isAscending = algorithmConfigs.typeOrder().equalsIgnoreCase("az");
        this.iterationTime = algorithmConfigs.skip();
        this.isNumeric = algorithmConfigs.isNumeric();
    }

    public abstract void sort();

    /**
     * Displays the sorted elements of strings.
     */
    protected void displaySortedArray() {
        mercury.showMessage("\nSorted List: " + elements);
    }

    /**
     * Displays the current state of the algorithm, including the iteration count and the current elements.
     */
    protected void displayCurrentState() {
        mercury.showMessage(
                AsciiColor.applyMultiple("ᓚᘏᗢ ", AsciiColor.YELLOW).repeat(iterationCount) + "\n"  +
                        "Iteration " + ": "
        );
        displayCurrentList();
        try {
            Thread.sleep(iterationTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Compares two elements considering whether they are numeric or not and the sorting direction.
     *
     * @param a First element for comparison
     * @param b Second element for comparison
     * @return true if 'a' should come before 'b' in the current ordering
     */
    protected boolean compare(String a, String b) {
        if (isNumeric) {
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            return isAscending ? numA <= numB : numA > numB;
        }

        if (isAscending) return a.compareTo(b) < 0;

        return a.compareTo(b) > 0;
    }

    /**
     * Swaps two positions in the array.
     *
     * @param i First position
     * @param j Second position
     */
    protected void swap(int i, int j) {
        String temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    /**
     * Displays the original list of strings before sorting.
     *
     * @return void - This method does not return any value. It only displays the original elements.
     */
    protected void displayOriginalList() {
        mercury.showMessage("Original elements: " + elements + "\n");
    }

    protected void displayCurrentList() {
        if (isNumeric) {
            List<Integer> integerList = elements.stream()
                    .map(Integer::parseInt)
                    .toList();

            int min = Collections.min(integerList);
            int max = Collections.max(integerList);
            int range = max - min;
            int row = 0;

            for (int element : integerList) {
                int pos = element - min + 1;
                int count = Math.round((float)pos / (float)range * 80.0F);
                System.out.printf("[%d]:\t%s %s\n", row++, "*".repeat(count), element);
            }

        }
        else {
            List<Integer> charValues = elements.stream()
                    .map(element -> mapCharToValue(element.charAt(0))) // Mapeia o primeiro caractere
                    .toList();

            int min = Collections.min(charValues);
            int max = Collections.max(charValues);
            int range = max - min;
            int row = 0;

            for (String element : elements) {
                char ch = element.charAt(0);
                int pos = mapCharToValue(ch) - min + 1;
                int count = Math.round((float)pos / (float)range * 80.0F);
                System.out.printf("[%d]:\t%s %s\n", row++, "*".repeat(count), element);
            }

        }
        System.out.println();

    }

    private int mapCharToValue(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A'; // Maiúsculas de 0 a 25
        } else if (ch >= 'a' && ch <= 'z') {
            return 26 + (ch - 'a'); // Minúsculas de 26 a 51
        }
        return -1; // Caso não seja uma letra (opcional)
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public boolean isAscending() {
        return isAscending;
    }

    public int getIterationTime() {
        return iterationTime;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public void setIterationCount(int iterationCount) {
        this.iterationCount = iterationCount;
    }

    public Mercury getMercury() {
        return mercury;
    }

    public void setMercury(Mercury mercury) {
        this.mercury = mercury;
    }

    public boolean isNumeric() {
        return isNumeric;
    }
}