package org.com.config;

/**
 * Enum representing various configuration rules for sorting algorithms.
 * Each enum constant represents a specific rule, such as sorting algorithm, list type, sorting order, source of list values,
 * random list size limits, quantity of arguments necessary, numeric value ranges, and allowing duplicates.
 *
 */
public enum Rules {
    // Sorting algorithms
    BUBBLE_SORT("B"),
    SELECTION_SORT("S"),
    QUICK_SORT("Q"),
    // List types
    NUMERIC("N"),
    CHARACTERS("C"),

    // Sorting order
    ASCENDING("ZA"),
    DESCENDING("AZ"),

    // Source of list values
    RANDOM("R"),
    USER_PROVIDED("M"),

    // Random list size limits
    MIN_SIZE(1),
    MAX_SIZE(40),

    QUANTITY_ARGUMENTS_NECESSARY(5),

    // Numeric value ranges
    MIN_VALUE_TIME(100),
    MIN_VALUE(-1000),
    MAX_VALUE(1000),

    // Allow duplicates
    ALLOW_DUPLICATES(true);

    private final Object value;

    Rules(Object value) {
        this.value = value;
    }

    /**
     * Get the value of the enum constant as a string.
     *
     * @return the value as a string
     */
    public String getText() {
        return (String) value;
    }

    /**
     * Get the value of the enum constant as an integer.
     *
     * @return the value as an integer
     */
    public int getInt() {
        return (int) value;
    }
}