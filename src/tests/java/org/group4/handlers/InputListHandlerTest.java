package org.group4.handlers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * The InputListHandlerTest class contains unit tests for the InputListHandler class.
 */
public class InputListHandlerTest {

    /**
     * Tests the handleInput method with a valid string type input.
     * This test case checks that the InputListHandler correctly handles and processes a valid string type input.
     */
    @Test
    public void testHandleInputWithValidStringType() {
        // Arrange
        InputListHandler handler = new InputListHandler("a,b,c", "c");

        // Act
        boolean isValid = handler.handleInput();
        List<String> result = handler.getAsString();

        // Assert
        assertTrue(isValid);
        assertEquals(List.of("a", "b", "c"), result);
    }

    /**
     * Tests the handleInput method with a valid integer type input.
     * This test case checks that the InputListHandler correctly handles and processes a valid integer type input.
     */
    @Test
    public void testHandleInputWithValidIntegerType() {
        // Arrange
        InputListHandler handler = new InputListHandler("1,2,3", "n");

        // Act
        boolean isValid = handler.handleInput();
        List<String> result = handler.getAsString();

        // Assert
        assertTrue(isValid);
        assertEquals(List.of("1", "2", "3"), result);
    }

    /**
     * Tests the handleInput method with an invalid integer type input.
     * This test case checks that the InputListHandler correctly identifies and handles an invalid integer type input.
     */
    @Test
    public void testHandleInputWithInvalidIntegerType() {
        // Arrange
        InputListHandler handler = new InputListHandler("1,9999,3", "n");

        // Act
        boolean isValid = handler.handleInput();

        // Assert
        assertFalse(isValid);
    }

    /**
     * Tests the handleInput method with a non-numeric input.
     * This test case checks that the InputListHandler correctly identifies and handles a non-numeric input.
     */
    @Test
    public void testHandleInputWithNonNumericInput() {
        // Arrange
        InputListHandler handler = new InputListHandler("1,abc,3", "n");

        // Act
        boolean isValid = handler.handleInput();

        // Assert
        assertFalse(isValid);
    }

    /**
     * Tests the getAsIntegers method with a valid input.
     * This test case checks that the InputListHandler correctly converts the input to a list of integers.
     */
    @Test
    public void testGetAsIntegersWithValidInput() {
        // Arrange
        InputListHandler handler = new InputListHandler("1,2,3", "n");
        handler.handleInput();

        // Act
        List<Integer> result = handler.getAsIntegers();

        // Assert
        assertEquals(List.of(1, 2, 3), result);
    }

    /**
     * Tests the getAsIntegers method with an invalid input.
     * This test case checks that the InputListHandler correctly handles an invalid input when converting to a list of integers.
     */
    @Test
    public void testGetAsIntegersWithInvalidInput() {
        // Arrange
        InputListHandler handler = new InputListHandler("1,abc,3", "n");
        handler.handleInput();

        // Act
        List<Integer> result = handler.getAsIntegers();

        // Assert
        assertTrue(result.isEmpty());
    }

    /**
     * Tests the getAsString method with a valid input.
     * This test case checks that the InputListHandler correctly returns the input as a list of strings.
     */
    @Test
    public void testGetAsStringWithValidInput() {
        // Arrange
        InputListHandler handler = new InputListHandler("a,b,c", "c");
        handler.handleInput();

        // Act
        List<String> result = handler.getAsString();

        // Assert
        assertEquals(List.of("a", "b", "c"), result);
    }

    /**
     * Tests the getAsString method with an invalid input.
     * This test case checks that the InputListHandler correctly handles an invalid input when returning a list of strings.
     */
    @Test
    public void testGetAsStringWithInvalidInput() {
        // Arrange
        InputListHandler handler = new InputListHandler("a,b,9999", "n");
        handler.handleInput();

        // Act
        List<String> result = handler.getAsString();

        // Assert
        assertTrue(result.isEmpty());
    }

    /**
     * Tests the splitInputList method with input containing spaces.
     * This test case checks that the InputListHandler correctly splits the input list with spaces.
     */
    @Test
    public void testSplitInputListWithSpaces() {
        // Arrange
        InputListHandler handler = new InputListHandler("a, b, c", "c");

        // Act
        String[] result = handler.splitInputList();

        // Assert
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    /**
     * Tests the splitInputList method with input without spaces.
     * This test case checks that the InputListHandler correctly splits the input list without spaces.
     */
    @Test
    public void testSplitInputListWithoutSpaces() {
        // Arrange
        InputListHandler handler = new InputListHandler("a,b,c", "c");

        // Act
        String[] result = handler.splitInputList();

        // Assert
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    /**
     * Tests the manipulateItemList method with a valid string type input.
     * This test case checks that the InputListHandler correctly manipulates and adds a valid string type item to the list.
     */
    @Test
    public void testManipulateItemListWithValidStringType() {
        // Arrange
        InputListHandler handler = new InputListHandler("", "c");

        // Act
        boolean isValid = handler.manipulateItemList("a");

        // Assert
        assertTrue(isValid);
        assertEquals(List.of("a"), handler.getAsString());
    }

    /**
     * Tests the manipulateItemList method with a valid integer type input.
     * This test case checks that the InputListHandler correctly manipulates and adds a valid integer type item to the list.
     */
    @Test
    public void testManipulateItemListWithValidIntegerType() {
        // Arrange
        InputListHandler handler = new InputListHandler("", "n");

        // Act
        boolean isValid = handler.manipulateItemList("1");

        // Assert
        assertTrue(isValid);
        assertEquals(List.of("1"), handler.getAsString());
        assertEquals(List.of(1), handler.getAsIntegers()); // Verifies the integer list
    }

    /**
     * Tests the manipulateItemList method with an invalid integer type input.
     * This test case checks that the InputListHandler correctly identifies and handles an invalid integer type input.
     */
    @Test
    public void testManipulateItemListWithInvalidIntegerType() {
        // Arrange
        InputListHandler handler = new InputListHandler("", "n");

        // Act
        boolean isValid = handler.manipulateItemList("abc");

        // Assert
        assertFalse(isValid);
    }

    /**
     * Tests the toIntArray method.
     * This test case checks that the InputListHandler correctly converts a list of strings to an array of integers.
     */
    @Test
    public void testToIntArray() {
        // Arrange
        InputListHandler handler = new InputListHandler();
        List<String> inputList = List.of("1", "2", "3");

        // Act
        Integer[] result = handler.toIntArray(inputList);

        // Assert
        assertArrayEquals(new Integer[]{1, 2, 3}, result);
    }

    /**
     * Tests the toCharArray method.
     * This test case checks that the InputListHandler correctly converts a list of strings to an array of characters.
     */
    @Test
    public void testToCharArray() {
        // Arrange
        InputListHandler handler = new InputListHandler();
        List<String> inputList = List.of("a", "b", "c");

        // Act
        Character[] result = handler.toCharArray(inputList);

        // Assert
        assertArrayEquals(new Character[]{'a', 'b', 'c'}, result);
    }
}