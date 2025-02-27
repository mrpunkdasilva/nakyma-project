package org.group4.ui;

import org.group4.config.AppConfigs;
import org.group4.handlers.InputListHandler;
import org.group4.base.IVisionRenderer;
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
    private final Mercury mercury;
    private final Scanner scanner;
    private final InputListHandler listHandler;
    private AppConfigs configs;

    /**
     * Constructs a new instance of the VisionRenderer class.
     */
    public VisionRenderer() {
        this.mercury = new Mercury();
        this.scanner = new Scanner(System.in);
        this.listHandler = new InputListHandler();
    }

    /**
     * Renders a message asking the user to press Enter to start the application.
     * The message is printed in italic and yellow color.
     */
    @Override
    public void renderPressStart() {
        Aengus.adjustVolume(0.5f);
        stopAndPlayMusic("src/main/resources/loading.wav", -1);
        mercury.showMessage("\n\n" + AsciiColor.applyMultiple(Texts.PRESS_ENTER.getText(), AsciiColor.ITALIC, AsciiColor.YELLOW));
        scanner.nextLine();
    }

    /**
     * Renders the logo of the application.
     */
    @Override
    public void renderLogo() {
        mercury.showMessage(Texts.NAKYMA_LOGO.getText());
    }

    /**
     * Renders the welcome message and the logo of the application.
     * Then, it calls the method to wait for the user to press Enter.
     */
    @Override
    public void renderWelcome() {
        playMusic("src/main/resources/game_start.wav", -1);
        renderLogo();
        mercury.showMessage("\n" + AsciiColor.applyMultiple(Texts.WELCOME.getText(), AsciiColor.MAGENTA, AsciiColor.BOLD));
        renderPressStart();
    }

    /**
     * Renders the visualizer for the sorting algorithm.
     * It first renders the header, then calls the method to render the specific sorting visualizer.
     */
    public void renderVisualizer() {
        renderHeader();
        renderSortingVisualizer();
    }

    /**
     * Renders the sorting visualizer based on the type of the input list (character or integer).
     */
    public void renderSortingVisualizer() {
        if (configs.typeList().equalsIgnoreCase("c")) {
            Character[] charArray = listHandler.toCharArray(configs.inputList());
            new SortingVisualizer<>(charArray, configs.s()).draw();
        } else {
            Integer[] intArray = listHandler.toIntArray(configs.inputList());
            new SortingVisualizer<>(intArray, configs.s()).draw();
        }
    }

    /**
     * Renders the header of the visualization table.
     */
    public void renderHeader() {
        mercury.showMessage(Texts.tableHeader(configs));
    }

    /**
     * Clears the console by printing a specified number of new lines.
     * @param count the number of new lines to print
     */
    @Override
    public void clear(int count) {
        mercury.showMessage("\033[H\033[2J");
        System.out.flush();
        mercury.showMessage("\n".repeat(count));
    }

    /**
     * Renders a loading animation with a progress bar.
     */
    public void loading() {
        mercury.showMessage(Texts.LOADING.getText());
        renderProgressBar(10, 10);
    }

    /**
     * Renders a progress bar with the specified number of total steps and bar length.
     * @param totalSteps the total number of steps in the progress bar
     * @param barLength the length of the progress bar
     */
    public void renderProgressBar(int totalSteps, int barLength) {
        for (int i = 1; i <= totalSteps; i++) {
            int progress = (i * barLength) / totalSteps;
            String bar = buildProgressBar(barLength, progress);
            System.out.print(AsciiColor.applyMultiple(bar, AsciiColor.BOLD, AsciiColor.GREEN));
            sleep(200);
        }
    }

    /**
     * Builds a progress bar string with the specified bar length and progress.
     * @param barLength the length of the progress bar
     * @param progress the current progress in the bar
     * @return the progress bar string
     */
    private String buildProgressBar(int barLength, int progress) {
        StringBuilder bar = new StringBuilder("\r[");
        for (int j = 0; j < barLength; j++) {
            bar.append(j < progress ? "=" : " ");
        }
        bar.append("] ").append(progress * 10).append("%");
        return bar.toString();
    }

    /**
     * Sleeps the current thread for the specified number of milliseconds.
     * @param milliseconds the number of milliseconds to sleep
     */
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Stops the currently playing music and plays a new one.
     * @param musicPath the path to the new music file
     * @param loops the number of times to loop the music (-1 for infinite loop)
     */
    public void stopAndPlayMusic(String musicPath, int loops) {
        Aengus.stopMusic();
        Aengus.playMusic(musicPath, loops);
    }

    /**
     * Plays a music file with the specified number of loops.
     * @param musicPath the path to the music file
     * @param loops the number of times to loop the music (-1 for infinite loop)
     */
     public void playMusic(String musicPath, int loops) {
        Aengus.playMusic(musicPath, loops);
    }

    /**
     * Sets the configurations for the VisionRenderer.
     * @param configs the AppConfigs object to be set
     */
    public void setConfigs(AppConfigs configs) {
        this.configs = configs;
    }
}