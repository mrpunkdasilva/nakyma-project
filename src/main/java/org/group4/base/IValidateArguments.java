package org.group4.base;

/**
 * Interface for validating arguments passed to the sorting algorithm.
 */
public interface IValidateArguments {

    boolean validadeQuantityMinimumArgument(String[] entryArguments);


    /**
     * Validates the type of sorting algorithm.
     *
     * @param type the type of sorting algorithm to be validated
     * @return true if the type is valid, false otherwise
     */
    boolean validateTypeSortAlgorithm(String type);

    /**
     * Validates the type of list.
     *
     * @param typeList the type of list to be validated
     * @return true if the type is valid, false otherwise
     */
    boolean validateTypeList(String typeList);

    /**
     * Validates the sorting order.
     *
     * @param order the sorting order to be validated
     * @return true if the order is valid, false otherwise
     */
    boolean validateSortingOrder(String order);

    /**
     * Validates the source list values.
     *
     * @param source the source list values to be validated
     * @return true if the source list values are valid, false otherwise
     */
    boolean validateSourceListValues(String source);

    /**
     * Validates the length of the list.
     *
     * @param length the length of the list to be validated
     * @return true if the length is valid, false otherwise
     */
    boolean validateLengthList(String length);

    /**
     * Validates the user input.
     *
     * @param list the user input to be validated
     * @return true if the user input is valid, false otherwise
     */
    boolean validateUserInput(String list, String typeList);

    /**
     * Validates the iteration time.
     *
     * @param time the iteration time to be validated
     * @return true if the iteration time is valid, false otherwise
     */
    boolean validateIterationTime(String time);

    boolean typeListIsCharacter(String type);
}