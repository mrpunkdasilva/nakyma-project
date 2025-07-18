package org.com;

import com.formdev.flatlaf.FlatDarkLaf;
import org.com.base.Algorithm;
import org.com.config.AlgorithmConfigs;
import org.com.sortAlgorithms.BubbleSort;
import org.com.sortAlgorithms.QuickSort;
import org.com.config.AppConfigs;
import org.com.handlers.ArgumentHandler;
import org.com.sortAlgorithms.SelectionSort;
import org.com.ui.SortingGUI;
import org.com.ui.SortingObserver;
import org.com.ui.VisionRenderer;
import org.com.utils.Mercury;
import org.com.values.Texts;

import javax.swing.*;
import java.awt.*;

/**
 * The main application class. It initializes the necessary components and runs the application.
 */
public class App {

    private AppConfigs configs;
    private final VisionRenderer vision;
    private final ArgumentHandler argumentHandler;
    private final Mercury mercury;
    private AlgorithmConfigs algorithmConfigs;
    private Algorithm algorithm;
    private SortingGUI sortingGUI;
    private JComboBox<String> algorithmComboBox;
    private JSlider speedSlider;
    private JButton startButton;


    /**
     * Constructs a new App instance.
     *
     * @param entryArguments The command-line arguments passed to the application.
     */
    public App(String[] entryArguments) {
        this.vision = new VisionRenderer();
        this.argumentHandler = new ArgumentHandler(entryArguments);
        this.mercury = new Mercury();
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

        startGUI();
    }


    /**
     * Builds and initializes the AlgorithmConfigs object based on the current application configurations.
     * This method sets up the necessary parameters for the sorting algorithm to be executed.
     * <p>
     * The AlgorithmConfigs object is created with the following parameters:
     *
     * @see AlgorithmConfigs
     * <p>
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

    private void initializeGUI() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame(Texts.TITLE_APP.getText());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        sortingGUI = new SortingGUI(configs.inputList(), configs.s());
        frame.add(sortingGUI, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        algorithmComboBox = new JComboBox<>(new String[]{"QuickSort", "BubbleSort", "SelectionSort"});
        speedSlider = new JSlider(0, 1000, configs.s());
        startButton = new JButton("Start");

        controlPanel.add(new JLabel("Algorithm:"));
        controlPanel.add(algorithmComboBox);
        controlPanel.add(new JLabel("Speed:"));
        controlPanel.add(speedSlider);
        controlPanel.add(startButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        startButton.addActionListener(e -> startSorting());

        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Implements the sorting algorithm based on the user's configuration.
     * This method initializes the appropriate sorting algorithm
     * according to the configuration, and then starts the algorithm execution.
     * *
     *
     * @throws IllegalStateException if the mercury object is not properly initialized
     * @see QuickSort
     * @see BubbleSort
     * @see SelectionSort
     */
    public void implementAlgorithm() {
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        algorithm = switch (selectedAlgorithm) {
            case "QuickSort" -> new QuickSort(algorithmConfigs);
            case "BubbleSort" -> new BubbleSort(algorithmConfigs);
            case "SelectionSort" -> new SelectionSort(algorithmConfigs);
            default -> null;
        };

        if (algorithm == null) {
            mercury.showError("Invalid algorithm type.");
        }
    }

    /**
     * Starts the selected sorting algorithm and initiates the sorting process.
     *
     * @throws IllegalArgumentException if the selected algorithm is invalid
     * @see Algorithm
     * @see SortingObserver
     */
    public void startSorting() {
        implementAlgorithm();
        sortingGUI.setAlgorithm(algorithm);
        sortingGUI.setDelay(speedSlider.getValue());

        SortingObserver observer = new SortingObserver(algorithm);
        algorithm.setObserver(observer);
        algorithmConfigs.setSortingGUI(sortingGUI);

        sortingGUI.startSorting();
    }



    public void startGUI() {
        initializeGUI();
    }
}
