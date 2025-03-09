package org.group4.sortAlgorithms;

import org.group4.config.AlgorithmConfigs;
import org.group4.ui.SortingGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


/**
 * The QuickSortTest class contains unit tests for the QuickSort class.
 */
public class QuickSortTest {

    private QuickSort quickSort;
    private SortingGUI visualizerMock;

    /**
     * Sets up the test environment by creating a mock SortingGUI instance to avoid unnecessary dependencies.
     */
    @BeforeEach
    void setUp() {
        // Mock the SortingGUI to avoid unnecessary dependencies
        visualizerMock = mock(SortingGUI.class);
    }

    /**
     * Tests the sort method with a list of numbers in ascending order.
     * This test case checks that the list is sorted correctly.
     */
    @Test
    void testSortAscendingNumbers() {
        // Configuration for sorting numbers in ascending order
        List<String> elements = Arrays.asList("5", "3", "8", "1", "2");
        AlgorithmConfigs configs = new AlgorithmConfigs(elements, "az", 100, true);
        quickSort = new QuickSort(configs);
        quickSort.setVisualizer(visualizerMock);

        // Execute the algorithm
        quickSort.sort(visualizerMock);

        // Verify that the list is sorted correctly
        List<String> expected = Arrays.asList("1", "2", "3", "5", "8");
        assertEquals(expected, quickSort.getElements());
    }

    /**
     * Tests the sort method with a list of numbers in descending order.
     * This test case checks that the list is sorted correctly.
     */
    @Test
    void testSortDescendingNumbers() {
        // Configuration for sorting numbers in descending order
        List<String> elements = Arrays.asList("5", "3", "8", "1", "2");
        AlgorithmConfigs configs = new AlgorithmConfigs(elements, "za", 100, true);
        quickSort = new QuickSort(configs);
        quickSort.setVisualizer(visualizerMock);

        // Execute the algorithm
        quickSort.sort(visualizerMock);

        // Verify that the list is sorted correctly
        List<String> expected = Arrays.asList("8", "5", "3", "2", "1");
        assertEquals(expected, quickSort.getElements());
    }

    /**
     * Tests the sort method with a list of strings in ascending order.
     * This test case checks that the list is sorted correctly.
     */
    @Test
    void testSortAscendingStrings() {
        // Configuration for sorting strings in ascending order
        List<String> elements = Arrays.asList("b", "a", "c", "d");
        AlgorithmConfigs configs = new AlgorithmConfigs(elements, "az", 100, false);
        quickSort = new QuickSort(configs);
        quickSort.setVisualizer(visualizerMock);

        // Execute the algorithm
        quickSort.sort(visualizerMock);

        // Verify that the list is sorted correctly
        List<String> expected = Arrays.asList("a", "b", "c", "d");
        assertEquals(expected, quickSort.getElements());
    }

    /**
     * Tests the sort method with a list that is already sorted.
     * This test case checks that the list remains the same after sorting.
     */
    @Test
    void testSortAlreadySorted() {
        // Configuration for a list that is already sorted
        List<String> elements = Arrays.asList("1", "2", "3", "4", "5");
        AlgorithmConfigs configs = new AlgorithmConfigs(elements, "az", 100, true);
        quickSort = new QuickSort(configs);
        quickSort.setVisualizer(visualizerMock);

        // Execute the algorithm
        quickSort.sort(visualizerMock);

        // Verify that the list remains the same
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5");
        assertEquals(expected, quickSort.getElements());
    }

    /**
     * Tests the sort method with an empty list.
     * This test case checks that the list remains empty after sorting.
     */
    @Test
    void testSortEmptyList() {
        // Configuration for an empty list
        List<String> elements = Arrays.asList();
        AlgorithmConfigs configs = new AlgorithmConfigs(elements, "az", 100, true);
        quickSort = new QuickSort(configs);
        quickSort.setVisualizer(visualizerMock);

        // Execute the algorithm
        quickSort.sort(visualizerMock);

        // Verify that the list remains empty
        List<String> expected = Arrays.asList();
        assertEquals(expected, quickSort.getElements());
    }
}