package org.group4.interfaces;

/**
 * This interface provides methods for rendering different elements in a user interface.
 */
public interface IVisionRenderer {

    /**
     * Renders the "Press Start" message on the screen.
     */
    void renderPressStart();

    /**
     * Renders the application logo on the screen.
     */
    void renderLogo();

    /**
     * Renders a welcome message on the screen.
     */
    void renderWelcome();

    /**
     * Clears the screen by erasing a specified number of lines.
     *
     * @param number The number of lines to clear. A value of 0 or less indicates clearing the entire screen.
     */
    void clear(int count);
}