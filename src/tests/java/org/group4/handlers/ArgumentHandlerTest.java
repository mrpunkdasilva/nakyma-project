package org.punkdomus.handlers;

import org.punkdomus.config.AppConfigs;
import org.punkdomus.utils.GenerateList;
import org.punkdomus.utils.Mercury;
import org.punkdomus.values.Texts;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



/**
 * The ArgumentHandlerTest class contains unit tests for the ArgumentHandler class.
 */
public class ArgumentHandlerTest {

    /**
     * Tests the verify method with an invalid sort algorithm.
     * This test case checks that the ArgumentHandler correctly handles and reports an invalid sort algorithm.
     */
    @Test
    public void testVerifyWithInvalidSortAlgorithm() {
        // Arrange
        String[] args = {"a=invalidAlgo", "t=c", "o=az", "in=m", "v=1,2,3", "s=100"};
        Mercury mockMercury = Mockito.mock(Mercury.class);
        ValidateHandler mockValidate = Mockito.mock(ValidateHandler.class);
        ArgumentHandler handler = new ArgumentHandler(args);

        when(mockValidate.validateTypeSortAlgorithm("invalidAlgo")).thenReturn(false);

        // Act & Assert
        handler.verify();
        verify(mockMercury, times(1)).showError(Texts.ERR_SORT_ALGO.getText());
    }

    /**
     * Tests the verify method with an invalid type list.
     * This test case checks that the ArgumentHandler correctly handles and reports an invalid type list.
     */
    @Test
    public void testVerifyWithInvalidTypeList() {
        // Arrange
        String[] args = {"a=b", "t=invalidTypeList", "o=asc", "in=m", "v=1,2,3", "s=100"};

        Mercury mockMercury = Mockito.mock(Mercury.class);
        GenerateList mockGenerateList = Mockito.mock(GenerateList.class);
        ValidateHandler mockValidate = Mockito.mock(ValidateHandler.class);

        when(mockValidate.validateTypeList("invalidType")).thenReturn(false);

        ArgumentHandler handler = new ArgumentHandler(args);

        // Act
        handler.verify();

        // Assert
        verify(mockMercury, times(1)).showError(Texts.ERR_TYPE_LIST.getText());
    }

    /**
     * Tests the verify method with an invalid sorting order.
     * This test case checks that the ArgumentHandler correctly handles and reports an invalid sorting order.
     */
    @Test
    public void testVerifyWithInvalidSortingOrder() {
        // Arrange
        String[] args = {"a=b", "t=n", "o=invalidOrder", "in=m", "v=1,2,3", "s=100"};

        Mercury mockMercury = Mockito.mock(Mercury.class);
        GenerateList mockGenerateList = Mockito.mock(GenerateList.class);
        ValidateHandler mockValidate = Mockito.mock(ValidateHandler.class);

        when(mockValidate.validateSortingOrder("invalidOrder")).thenReturn(false);

        ArgumentHandler handler = new ArgumentHandler(args);

        // Act
        handler.verify();

        // Assert
        verify(mockMercury, times(1)).showError(Texts.ERR_ORDER.getText());
    }

    /**
     * Tests the createAppConfigs method with manual input.
     * This test case checks that the ArgumentHandler correctly creates an AppConfigs object with the provided manual input.
     */
    @Test
    public void testCreateAppConfigsWithManualInput() {
        // Arrange
        String[] args = {"a=b", "t=n", "o=az", "in=m", "v=1,2,3", "s=100"};
        ArgumentHandler handler = new ArgumentHandler(args);

        // Act
        AppConfigs configs = handler.createAppConfigs();

        // Assert
        assertNotNull(configs);
        assertEquals("b", configs.getSortAlgorithm());
        assertEquals("n", configs.getTypeList());
        assertEquals("az", configs.getSortingOrder());
        assertEquals("m", configs.getSourceList());
        assertEquals(List.of("1", "2", "3"), configs.getInputList());
        assertEquals(100, configs.getIterationTime());
    }

    /**
     * Tests the createAppConfigs method with random input.
     * This test case checks that the ArgumentHandler correctly creates an AppConfigs object with the provided random input.
     */
    @Test
    public void testCreateAppConfigsWithRandomInput() {
        // Arrange
        String[] args = {"a=b", "t=n", "o=az", "in=r", "r=5", "s=100"};
        ArgumentHandler handler = new ArgumentHandler(args);

        // Act
        AppConfigs configs = handler.createAppConfigs();

        // Assert
        assertNotNull(configs);
        assertEquals("b", configs.getSortAlgorithm());
        assertEquals("n", configs.getTypeList());
        assertEquals("az", configs.getSortingOrder());
        assertEquals("r", configs.getSourceList());
        assertEquals(5, configs.getRandomLengthList());
        assertEquals(100, configs.getIterationTime());
        assertEquals(5, configs.getInputList().size());
    }

    /**
     * Tests the getArgumentByKey method with an existing key.
     * This test case checks that the ArgumentHandler correctly retrieves the value for an existing key.
     */
    @Test
    public void testGetArgumentByKeyWithExistingKey() {
        // Arrange
        String[] args = {"a=b", "t=n", "o=az", "in=m", "v=1,2,3", "s=100"};
        ArgumentHandler handler = new ArgumentHandler(args);

        // Act
        String value = handler.getArgumentByKey("a");

        // Assert
        assertEquals("b", value);
    }

    /**
     * Tests the getArgumentByKey method with a non-existing key.
     * This test case checks that the ArgumentHandler correctly handles a non-existing key.
     */
    @Test
    public void testGetArgumentByKeyWithNonExistingKey() {
        // Arrange
        String[] args = {"a=b", "t=n", "o=az", "in=m", "v=1,2,3", "s=100"};
        ArgumentHandler handler = new ArgumentHandler(args);

        // Act
        String value = handler.getArgumentByKey("nonexistent");

        // Assert
        assertEquals("", value);
    }
}