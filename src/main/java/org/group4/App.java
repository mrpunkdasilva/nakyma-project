package org.group4;

import org.group4.config.AlgorithmConfigs;
import org.group4.sortAlgorithms.BubbleSort;
import org.group4.sortAlgorithms.QuickSort;
import org.group4.config.AppConfigs;
import org.group4.handlers.ArgumentHandler;
import org.group4.sortAlgorithms.SelectionSort;
import org.group4.ui.SortingObserver;
import org.group4.ui.VisionRenderer;
import org.group4.utils.Mercury;

/**
 * The main application class. It initializes the necessary components and runs the application.
 */
public class App {

    private AppConfigs configs;
    private final VisionRenderer vision;
    private final ArgumentHandler argumentHandler;
    private final Mercury mercury = new Mercury();
    private AlgorithmConfigs algorithmConfigs;


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
        vision.sleep(300);
        vision.clear(100);

        vision.renderHeader();
        vision.clear(1);

        buildAlgorithmConfigs();

        implementAlgorithm();
    }

    public void buildAlgorithmConfigs() {
        algorithmConfigs = new AlgorithmConfigs(
                configs.inputList(),
                configs.o(),
                configs.s(),
                configs.typeList().equalsIgnoreCase("n")
        );
    }

    public void implementAlgorithm() {
        switch (configs.a()) {
            case "q" -> {
                QuickSort quickSort = new QuickSort(algorithmConfigs);
                SortingObserver observer = new SortingObserver(quickSort);
                quickSort.setObserver(observer);
                quickSort.sort();
            }
            case "b" -> {
                BubbleSort bubbleSort = new BubbleSort(algorithmConfigs);
                SortingObserver observer = new SortingObserver(bubbleSort);
                bubbleSort.setObserver(observer);
                bubbleSort.sort();
            }
            case "s" -> {
                SelectionSort selectionSort = new SelectionSort(algorithmConfigs);
                SortingObserver observer = new SortingObserver(selectionSort);
                selectionSort.setObserver(observer);
                selectionSort.sort();
            }
            default -> mercury.showError("Algorithm not supported.");
        }
    }
}
