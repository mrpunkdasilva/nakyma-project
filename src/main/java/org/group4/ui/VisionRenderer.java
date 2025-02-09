package org.group4.ui;

import org.group4.handlers.InputListHandler;
import org.group4.interfaces.IVisionRenderer;
import org.group4.utils.Aengus;
import org.group4.values.AsciiColor;
import org.group4.values.Texts;
import org.group4.utils.Mercury;

import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for rendering the user interface elements of the application.
 * It implements the {@link IVisionRenderer} interface, which defines the methods for rendering specific elements.
 */
public class VisionRenderer implements IVisionRenderer {
    private final Mercury mercury = new Mercury();
    private final Scanner scanner = new Scanner(System.in);
    private final InputListHandler listHandler = new InputListHandler();

    /**
     * Renders a message asking the user to press Enter to start the application.
     * The message is printed in italic and yellow color.
     */
    @Override
    public void renderPressStart() {
        // For any song that's playing
        Aengus.stopMusic();

        // Play the new song
        Aengus.playMusic("src/main/resources/loading.wav", -1);

        // Displays the message and waits for Enter
        mercury.showMessage("\n\n" + AsciiColor.applyMultiple(Texts.PRESS_ENTER.getText(), AsciiColor.ITALIC, AsciiColor.YELLOW));
        scanner.nextLine();
    }

    @Override
    public void renderLogo() {
        mercury.showMessage(Texts.NAKYMA_LOGO.getText());
    }

    @Override
    public void renderWelcome() {
        // Play the welcome music
        Aengus.playMusic("src/main/resources/game_start.wav", 0); // Toca uma vez (sem loop)

        // Render the logo
        renderLogo();

        // Displays the welcome message
        mercury.showMessage("\n" + AsciiColor.applyMultiple(Texts.WELCOME.getText(), AsciiColor.MAGENTA, AsciiColor.BOLD));

        // Calls the method to wait for Enter
        renderPressStart();
    }

    public void renderMatrix(List<String> inputMatrix) {
        renderHeader();

        for (String matrix : inputMatrix) {
            System.out.println(matrix);
        }
    }

    private void renderHeader() {
        mercury.showMessage("""
                
                """);
    }

    /**
     * Clears the console by printing a specified number of new lines.
     */
    @Override
    public void clear(int count) {
        mercury.showMessage("\033[H\033[2J");
        System.out.flush();
        mercury.showMessage("\n".repeat(count));
    }

    public void loading() {
        mercury.showMessage(Texts.LOADING.getText());

        int totalSteps = 10;
        int barLength = 20;

        for (int i = 1; i <= totalSteps; i++) {
            int progress = (i * barLength) / totalSteps;
            StringBuilder bar = new StringBuilder("\r[");

            // Add the completed blocks
            for (int j = 0; j < barLength; j++) {
                bar.append(j < progress ? "=" : " ");
            }

            bar.append("] ").append(i * 10).append("%");

            // Updates the bar in the console
            System.out.print(AsciiColor.applyMultiple(bar.toString(), AsciiColor.BOLD, AsciiColor.GREEN));

            sleep(500);
        }
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
