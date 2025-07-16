package org.com.values;

import java.util.Random;

public enum AsciiColor {
    // Default ANSI text colors
    BLACK("30"),
    RED("31"),
    GREEN("32"),
    YELLOW("33"),
    BLUE("34"),
    MAGENTA("35"),
    CYAN("36"),
    WHITE("37"),

    // Default ANSI background colors
    BG_BLACK("40"),
    BG_RED("41"),
    BG_GREEN("42"),
    BG_YELLOW("43"),
    BG_BLUE("44"),
    BG_MAGENTA("45"),
    BG_CYAN("46"),
    BG_WHITE("47"),

    // Text styles
    BOLD("1"),
    ITALIC("3"),

    // Reset
    RESET("0");

    private static final String ASCII_MARK_INIT = "\u001B[";
    private static final String ASCII_MARK_END = ASCII_MARK_INIT + RESET.code + "m";
    private static final String ASCII_SEPARATOR = ";";
    private static final String ASCII_TOKEN = "m";

    private static final Random RANDOM = new Random();

    private final String code;

    AsciiColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * Returns the ANSI escape code for this color or style.
     */
    public String toEscapeCode() {
        return ASCII_MARK_INIT + code + ASCII_TOKEN;
    }

    /**
     * Applies the color or style to a text and returns the formatted text.
     * @param text Text to format.
     * @return Formatted text with ANSI codes.
     */
    public String apply(String text) {
        return toEscapeCode() + text + ASCII_MARK_END;
    }

    /**
     * Generates an ANSI code for a custom RGB color (text).
     *
     * @param r Red value (0-255).
     * @param g Green value (0-255).
     * @param b Blue value (0-255).
     * @return ANSI code for the RGB color.
     */
    public static String customTextColor(int r, int g, int b) {
        return ASCII_MARK_INIT + "38;2;" + r + ASCII_SEPARATOR + g + ASCII_SEPARATOR + b + ASCII_TOKEN;
    }

    /**
     * Generates an ANSI code for a custom RGB color (background).
     *
     * @param r Red value (0-255).
     * @param g Green value (0-255).
     * @param b Blue value (0-255).
     * @return ANSI code for the RGB background color.
     */
    public static String customBackgroundColor(int r, int g, int b) {
        return ASCII_MARK_INIT + "48;2;" + r + ASCII_SEPARATOR + g + ASCII_SEPARATOR + b + ASCII_TOKEN;
    }

    /**
     * Applies multiple styles to text and returns the formatted text.
     *
     * @param text   Text to format.
     * @param styles Styles to be applied (colors and/or formatting).
     * @return Formatted text with ANSI codes.
     */
    public static String applyMultiple(String text, AsciiColor... styles) {
        StringBuilder styleCodes = new StringBuilder(ASCII_MARK_INIT);
        for (int i = 0; i < styles.length; i++) {
            styleCodes.append(styles[i].getCode());
            if (i < styles.length - 1) {
                styleCodes.append(ASCII_SEPARATOR);
            }
        }
        styleCodes.append(ASCII_TOKEN);
        return styleCodes + text + ASCII_MARK_END;
    }

    /**
     * Returns a random text color.
     * @return A random AsciiColor for text.
     */
    public static AsciiColor randomTextColor() {
        AsciiColor[] colors = { RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE };
        return colors[RANDOM.nextInt(colors.length)];
    }
}
