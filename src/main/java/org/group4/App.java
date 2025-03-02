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
     * Runs the application by executing a series of steps to set up and perform the sorting algorithm.
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

    
        /**
     * Builds and initializes the AlgorithmConfigs object based on the current application configurations.
     * This method sets up the necessary parameters for the sorting algorithm to be executed.
     * 
     * The AlgorithmConfigs object is created with the following parameters:
     * @see AlgorithmConfigs
     * 
     * - inputList: The list of elements to be sorted
     * - o: The order of sorting (ascending or descending)
     * - s: The step size for the sorting process
     * - isNumeric: Whether the list contains numeric values (true) or not (false)
     */
    public void buildAlgorithmConfigs() {
        algorithmConfigs = new AlgorithmConfigs(
                configs.inputList(),
                configs.o(),
                configs.s(),
                configs.typeList().equalsIgnoreCase("n")
        );
    }

     /**
     * Implements the sorting algorithm based on the user's configuration.
     * This method initializes the appropriate sorting algorithm
     * according to the configuration, and then starts the algorithm execution.
      * *
     * @throws IllegalStateException if the mercury object is not properly initialized
     * @see QuickSort
     * @see BubbleSort
     * @see SelectionSort
     */
    public void implementAlgorithm() {
        algorithm = switch (configs.a()) {
            case "q" -> new QuickSort(algorithmConfigs);
            case "b" -> new BubbleSort(algorithmConfigs);
            case "s" -> new SelectionSort(algorithmConfigs);
            default -> null;
        };

        if (algorithm == null) {
            mercury.showError("Invalid algorithm type.");
        }

        startAlgorithm();
    }

    /**
     * Starts the selected sorting algorithm and initiates the sorting process.
     *
     * @throws IllegalArgumentException if the selected algorithm is invalid
     * @see Algorithm
     * @see SortingObserver
     */
    public void startAlgorithm() {
         SortingObserver observer = new SortingObserver(algorithm);
         algorithm.setObserver(observer);
         algorithm.sort();
    }

}
