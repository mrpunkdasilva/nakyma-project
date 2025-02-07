package org.group4.utils;

import org.group4.values.AsciiColor;
import org.group4.values.Texts;

/**
 * This class provides utility methods for displaying messages and errors.
 */
public class Mercury {

    /**
     * Displays an error message with a red, bold, and italic font style,
     * followed by an error icon. The program will then terminate with an exit code of 1.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(
                AsciiColor.applyMultiple(message, AsciiColor.BOLD, AsciiColor.RED, AsciiColor.ITALIC)
                        +
                        Texts.ERROR_ICON.getText()
        );

        System.exit(1);
    }

    /**
     * Displays a simple message without any formatting.
     *
     * @param message The message to be displayed.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}
