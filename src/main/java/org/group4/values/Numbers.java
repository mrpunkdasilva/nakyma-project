package org.group4.values;

import java.util.Arrays;
import java.util.Random;

public enum Numbers {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    ELEVEN(11), TWELVE(12), THIRTEEN(13), FOURTEEN(14), FIFTEEN(15),
    SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINETEEN(19), TWENTY(20),
    TWENTY_ONE(21), TWENTY_TWO(22), TWENTY_THREE(23), TWENTY_FOUR(24), TWENTY_FIVE(25),
    TWENTY_SIX(26), TWENTY_SEVEN(27), TWENTY_EIGHT(28), TWENTY_NINE(29), THIRTY(30),
    THIRTY_ONE(31), THIRTY_TWO(32), THIRTY_THREE(33), THIRTY_FOUR(34), THIRTY_FIVE(35),
    THIRTY_SIX(36), THIRTY_SEVEN(37), THIRTY_EIGHT(38), THIRTY_NINE(39), FORTY(40);

    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value of this enum constant.
     *
     * @return The integer representation of the number.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns the corresponding Numbers enum for a given integer.
     *
     * @param value The integer to convert.
     * @return The matching Numbers enum, or null if invalid.
     */
    public static Numbers fromValue(Integer value) {
        if (value == null) return null;
        return Arrays.stream(Numbers.values())
                .filter(n -> n.value == value)
                .findFirst()
                .orElse(null);
    }

    /**
     * Checks if the given integer exists in the enum.
     *
     * @param number The integer to check.
     * @return True if the number exists in the enum, false otherwise.
     */
    public static boolean contains(Integer number) {
        return fromValue(number) != null;
    }

    /**
     * Returns the number of elements in the enum.
     *
     * @return The total count of numbers.
     */
    public static int count() {
        return Numbers.values().length;
    }

    /**
     * Returns an array of all numbers in the enum.
     *
     * @return An array of Numbers.
     */
    public static Numbers[] getArray() {
        return Numbers.values();
    }

    /**
     * Returns a random number from the enum.
     *
     * @return A random Numbers enum value.
     */
    public static Numbers getRandom() {
        Random random = new Random();
        return getArray()[random.nextInt(count())];
    }
}
