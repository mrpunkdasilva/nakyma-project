package org.com.base;

import org.com.config.AlgorithmConfigs;
import org.com.ui.SortingGUI;
import org.com.utils.Mercury;
import org.com.values.AsciiColor;

import java.util.Collections;
import java.util.List;

/**
 * This is an abstract class representing an algorithm. It provides common attributes and methods for sorting algorithms.
 */
public abstract class Algorithm {
    private IObserver observer;

    /**
     * Sets an observer to listen for updates in the algorithm's state.
     *
     * @param observer The observer instance to be notified.
     */

    public void setObserver(IObserver observer) {
        this.observer = observer;
    }

    /**
     * Notifies the observer of the algorithm's current state.
     */
    protected void notifyObserver() {
        if (observer != null) {
            observer.update();
        }
    }


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

    protected boolean isNumeric;


    protected SortingGUI visualizer;


    /**
     * Constructs an instance of the Algorithm class.
     */
    protected Algorithm(AlgorithmConfigs algorithmConfigs) {
        this.elements = algorithmConfigs.elements();
        this.isAscending = algorithmConfigs.typeOrder().equalsIgnoreCase("az");
        this.iterationTime = algorithmConfigs.skip();
        this.isNumeric = algorithmConfigs.isNumeric();
    }

    public void setVisualizer(SortingGUI visualizer) {
        this.visualizer = visualizer;
    }

    public abstract void sort(SortingGUI visualizer);

    /**
     * Displays the sorted elements of strings.
     */
    protected void displaySortedArray() {
        mercury.showMessage("\nSorted List: " + elements);
    }

    /**
     * Displays the current state of the algorithm, including the iteration count and the current elements.
     */
    public void displayCurrentState() {
        mercury.showMessage("Iteration [" + iterationCount + "] : ");
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
        // Se estamos lidando com números
        if (isNumeric) {
            try {
                int numA = Integer.parseInt(a);
                int numB = Integer.parseInt(b);
                return isAscending ? numA < numB : numA > numB;
            } catch (NumberFormatException e) {
                // Se a conversão falhar, trate como strings
                isNumeric = false; // Mude o estado para não numérico
            }
        }

        // Se estamos lidando com letras
        return isAscending ? a.compareTo(b) <= 0 : a.compareTo(b) >= 0;
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

    /**
     * Displays the current list formatted as a histogram.
     * If the elements are numeric, it displays a histogram based on their values.
     * If the elements are characters, it converts them to numeric values and displays a corresponding histogram.
     */
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
                int count = randomNumberCount((float) pos, (float) range);
                System.out.printf("[%d]:\t%s %s\n", row++, getElementFormated(count), element);
            }

        } else {
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
                int count = randomNumberCount((float) pos, (float) range);
                System.out.printf("[%d]:\t%s %s\n", row++, getElementFormated(count), element);
            }

        }

        System.out.println();
    }

    /**
     * Calculates an integer value based on the provided position and range.
     * The value is obtained by dividing the position by the range, multiplying by the maximum value (80.0),
     * and rounding the result to the nearest integer.
     *
     * @param pos   The current position, represented as a float value.
     * @param range The maximum range, represented as a float value.
     * @return An integer value rounded based on the formula: Math.round(pos / range * number).
     */
    private int randomNumberCount(float pos, float range) {
        float maxValue = 80.0F;
        return Math.round(pos / range * maxValue);
    }

    /**
     * Returns a formatted string consisting of a cat face emoji ("😺") repeated a specific number of times.
     * Each occurrence of the emoji is randomly colored using an ASCII text color function.
     *
     * @param count The number of times the emoji should be repeated.
     * @return A formatted string containing the repeated and colored emoji.
     */
    private String getElementFormated(int count) {
        return AsciiColor.randomTextColor().apply("\uD83D\uDE3A").repeat(count);
    }

    /**
     * Converts a character into a numeric value for sorting and comparison.
     * Uppercase letters (A-Z) are mapped to values from 0 to 25.
     * Lowercase letters (a-z) are mapped to values from 26 to 51.
     * Other characters return -1.
     *
     * @param ch the character to be mapped
     * @return the numeric value corresponding to the character or -1 if invalid
     */
    private int mapCharToValue(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A'; // Maiúsculas de 0 a 25
        } else if (ch >= 'a' && ch <= 'z') {
            return 26 + (ch - 'a'); // Minúsculas de 26 a 51
        }
        return -1; // Caso não seja uma letra (opcional)
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public List<String> getElements() {
        return elements;
    };
}