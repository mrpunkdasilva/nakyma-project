package org.group4;

import org.group4.sortAlgorithms.QuickSort;
import org.group4.config.AppConfigs;
import org.group4.handlers.ArgumentHandler;
import org.group4.ui.VisionRenderer;

/**
 * The main application class. It initializes the necessary components and runs the application.
 */
public class App {

    private AppConfigs configs;
    private final VisionRenderer vision;
    private final ArgumentHandler argumentHandler;


    /**
     * Constructs a new App instance.
     *
     * @param entryArguments The command-line arguments passed to the application.
     */
    public App(String[] entryArguments) {
        this.vision = new VisionRenderer();
        this.argumentHandler = new ArgumentHandler(entryArguments);
    }

    /**
     * Runs the application.
     */
    public void run() {
        vision.renderWelcome();
        vision.clear(50);

        argumentHandler.verify();
        configs = argumentHandler.createAppConfigs();
        vision.setConfigs(configs);

        vision.loading();
        vision.sleep(500);
        vision.clear(100);

        vision.renderHeader();

        vision.clear(1);

        QuickSort quickSort = new QuickSort(
                configs.inputList(),
                configs.o(),
                configs.s(),
                configs.typeList().equalsIgnoreCase("n")
        );
        quickSort.sort();

    }
}
