package org.punkdomus.utils;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * The GenerateListTest class contains unit tests for the GenerateList class.
 */
public class GenerateListTest {

    /**
     * Tests the generate method with the "c" type, which generates a list of characters.
     * This test case checks that the generated list contains the correct number of elements and that each element is a valid character.
     */
    @Test
    public void testGenerateCharacters() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act
        String result = generator.generate("c", 5);

        // Assert
        assertNotNull(result); // Verifies that the list was generated
        assertEquals(5, result.split(",").length); // Verifies that the list has 5 elements
        for (String item : result.split(",")) {
            assertTrue(item.length() == 1 && Character.isLetter(item.charAt(0))); // Verifies that each item is a character
        }
    }

    /**
     * Tests the generate method with the "n" type, which generates a list of numbers.
     * This test case checks that the generated list contains the correct number of elements and that each element is a valid number.
     */
    @Test
    public void testGenerateNumbers() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act
        String result = generator.generate("n", 5);

        // Assert
        assertNotNull(result); // Verifies that the list was generated
        assertEquals(5, result.split(",").length); // Verifies that the list has 5 elements
        for (String item : result.split(",")) {
            assertTrue(item.matches("\\d+")); // Verifies that each item is a number
        }
    }

    /**
     * Tests the generate method with an invalid type.
     * This test case checks that the method returns an empty string when an invalid type is provided.
     */
    @Test
    public void testGenerateWithInvalidType() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act & Assert
        assertEquals("", generator.generate("m", 12));
    }

    /**
     * Tests the makeList method with the "c" type, which generates a list of characters.
     * This test case checks that the generated list contains the correct number of elements and that each element is a valid character.
     */
    @Test
    public void testMakeListWithCharacters() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act
        String result = generator.generate("c", 5);

        // Assert
        assertNotNull(result); // Verifies that the list was generated
        assertEquals(5, result.split(",").length); // Verifies that the list has 5 elements
        for (String item : result.split(",")) {
            assertTrue(item.length() == 1 && Character.isLetter(item.charAt(0))); // Verifies that each item is a character
        }
    }

    /**
     * Tests the makeList method with the "n" type, which generates a list of numbers.
     * This test case checks that the generated list contains the correct number of elements and that each element is a valid number.
     */
    @Test
    public void testMakeListWithNumbers() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act
        String result = generator.generate("n", 5);

        // Assert
        assertNotNull(result); // Verifies that the list was generated
        assertEquals(5, result.split(",").length); // Verifies that the list has 5 elements
        for (String item : result.split(",")) {
            assertTrue(item.matches("\\d+")); // Verifies that each item is a number
        }
    }

    /**
     * Tests the generateCharacters method, which generates a list of characters.
     * This test case checks that the generated list contains the correct number of elements and that each element is a valid character.
     */
    @Test
    public void testGenerateCharactersMethod() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act
        String result = generator.generate("c", 5);

        // Assert
        assertNotNull(result); // Verifies that the list was generated
        assertEquals(5, result.split(",").length); // Verifies that the list has 5 elements
        for (String item : result.split(",")) {
            assertTrue(item.length() == 1 && Character.isLetter(item.charAt(0))); // Verifies that each item is a character
        }
    }

    /**
     * Tests the generateNumbers method, which generates a list of numbers.
     * This test case checks that the generated list contains the correct number of elements and that each element is a valid number.
     */
    @Test
    public void testGenerateNumbersMethod() {
        // Arrange
        GenerateList generator = new GenerateList();

        // Act
        String result = generator.generate("n", 5);

        // Assert
        assertNotNull(result); // Verifies that the list was generated
        assertEquals(5, result.split(",").length); // Verifies that the list has 5 elements
        for (String item : result.split(",")) {
            assertTrue(item.matches("\\d+")); // Verifies that each item is a number
        }
    }
}