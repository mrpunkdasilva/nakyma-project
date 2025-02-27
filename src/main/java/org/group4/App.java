package org.group4;

import org.group4.base.Algorithm;
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
    private Algorithm algorithm;


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
        vision.sleep(100);
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
        algorithm = switch (configs.a()) {
            case "q" -> new QuickSort(algorithmConfigs);
            case "b" -> new BubbleSort(algorithmConfigs);
            case "s" -> new SelectionSort(algorithmConfigs);
            default -> null;
        };

        if (algorithm != null) {
            startAlgorithm();
        } else {
            mercury.showError("Invalid algorithm type.");
        }
    }

    public void startAlgorithm() {
         SortingObserver observer = new SortingObserver(algorithm);
         algorithm.setObserver(observer);
         algorithm.sort();
    }

}
