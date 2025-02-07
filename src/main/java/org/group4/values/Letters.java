package org.group4.values;

import java.util.Random;

public enum Letters {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    /**
     * Returns the corresponding Letters enum for a given character.
     *
     * @param letter The character to convert.
     * @return The matching Letters enum, or null if invalid.
     */
    public static Letters fromValue(Character letter) {
        if (letter == null) return null;
        try {
            return Letters.valueOf(Character.toUpperCase(letter) + "");
        } catch (IllegalArgumentException e) {
            return null; // Retorna null se não encontrar uma letra correspondente.
        }
    }

    /**
     * Checks if the given character exists in the enum.
     *
     * @param letter The character to check.
     * @return True if the letter exists in the enum, false otherwise.
     */
    public static boolean contains(Character letter) {
        return fromValue(letter) != null;
    }

    /**
     * Returns the character value of this enum constant.
     *
     * @return The character representation of the letter.
     */
    public Character getValue() {
        return this.name().charAt(0);
    }

    /**
     * Returns the number of letters in the enum.
     *
     * @return The total count of letters.
     */
    public static int count() {
        return Letters.values().length;
    }

    /**
     * Returns an array of all the letters in the enum.
     *
     * @return An array of Letters.
     */
    public static Letters[] getArray() {
        return Letters.values();
    }

    /**
     * Returns a random letter from the enum.
     *
     * @return A random Letters enum value.
     */
    public static Letters getRandom() {
        Random random = new Random();
        return getArray()[random.nextInt(count())];
    }
}
