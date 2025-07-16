package org.com.handlers;

import org.com.config.Rules;
import org.com.base.IValidateArguments;

/**
 * This class provides methods for validating different aspects of the sorting application.
 * It implements the {@link IValidateArguments} interface, which defines the methods for validating input arguments.
 */
public class ValidateHandler implements IValidateArguments {

    /**
     * Validates if the quantity of arguments provided is minimum necessary.
     *
     * @param entryArguments The array of arguments provided by the user.
     * @return {@code true} if the quantity of arguments is minimum necessary, {@code false} otherwise.
     */
    @Override
    public boolean validadeQuantityMinimumArgument(String[] entryArguments) {
        return entryArguments.length >= Rules.QUANTITY_ARGUMENTS_NECESSARY.getInt();
    }

    /**
     * Validates if the provided sorting algorithm type is supported.
     *
     * @param type The type of sorting algorithm.
     * @return {@code true} if the sorting algorithm type is supported, {@code false} otherwise.
     */
    @Override
    public boolean validateTypeSortAlgorithm(String type) {
        return type.equalsIgnoreCase(Rules.BUBBLE_SORT.getText()) ||
                type.equalsIgnoreCase(Rules.SELECTION_SORT.getText()) ||
                type.equalsIgnoreCase(Rules.QUICK_SORT.getText());
    }

    /**
     * Validates if the provided list type is supported.
     *
     * @param typeList The type of list.
     * @return {@code true} if the list type is supported, {@code false} otherwise.
     */
    @Override
    public boolean validateTypeList(String typeList) {
        return typeList.equalsIgnoreCase(Rules.CHARACTERS.getText()) ||
                typeList.equalsIgnoreCase(Rules.NUMERIC.getText());
    }

    /**
     * Validates if the provided sorting order is supported.
     *
     * @param order The sorting order.
     * @return {@code true} if the sorting order is supported, {@code false} otherwise.
     */
    @Override
    public boolean validateSortingOrder(String order) {
        return order.equalsIgnoreCase(Rules.ASCENDING.getText()) ||
                order.equalsIgnoreCase(Rules.DESCENDING.getText());
    }

    /**
     * Validates if the provided source of list values is supported.
     *
     * @param source The source of list values.
     * @return {@code true} if the source of list values is supported, {@code false} otherwise.
     */
    @Override
    public boolean validateSourceListValues(String source) {
        return source.equalsIgnoreCase(Rules.RANDOM.getText()) ||
                source.equalsIgnoreCase(Rules.USER_PROVIDED.getText());
    }

    /**
     * Validates if the provided length of the list is within the supported range.
     *
     * @param length The length of the list.
     * @return {@code true} if the length of the list is within the supported range, {@code false} otherwise.
     */
    @Override
    public boolean validateLengthList(String length) {
        try {
            int lengthInt = Integer.parseInt(length);
            return lengthInt >= Rules.MIN_SIZE.getInt() && lengthInt <= Rules.MAX_SIZE.getInt();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if the provided user input for the list is valid based on the list type.
     *
     * @param list     The user input for the list.
     * @param typeList The type of list.
     * @return {@code true} if the user input for the list is valid, {@code false} otherwise.
     */
    @Override
    public boolean validateUserInput(String list, String typeList) {
        InputListHandler inputListHandler = new InputListHandler(list, typeList);

        if (!list.isEmpty()) {
            if (typeList.equalsIgnoreCase(Rules.CHARACTERS.getText()) || typeList.equalsIgnoreCase(Rules.NUMERIC.getText())) {
                return inputListHandler.handleInput();
            }
        }

        return false;
    }

    /**
     * Validates if the provided iteration time is within the supported range.
     *
     * @param time The iteration time.
     * @return {@code true} if the iteration time is within the supported range, {@code false} otherwise.
     */
    @Override
    public boolean validateIterationTime(String time) {
        try {
            int timeInt = Integer.parseInt(time);
            return timeInt >= Rules.MIN_VALUE_TIME.getInt() && timeInt <= Rules.MAX_VALUE.getInt();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean typeListIsCharacter(String type) {
        return type.equalsIgnoreCase(Rules.CHARACTERS.getText());
    }
}
