package org.com.config;

import org.com.ui.SortingGUI;

/**
 * Represents the configuration settings for an algorithm.
 */
public class AlgorithmConfigs {
    private final java.util.List<String> elements;
    private final String typeOrder;
    private final int skip;
    private final boolean isNumeric;
    private SortingGUI sortingGUI; // Campo não final para permitir modificação

    /**
     * Construtor principal.
     *
     * @param elements A list of elements to be processed by the algorithm.
     * @param typeOrder A string representing the order of data types to be considered.
     * @param skip An integer representing the number of elements to skip during processing.
     * @param isNumeric A boolean indicating whether the elements are numeric or not.
     */
    public AlgorithmConfigs(java.util.List<String> elements, String typeOrder, int skip, boolean isNumeric) {
        this.elements = elements;
        this.typeOrder = typeOrder;
        this.skip = skip;
        this.isNumeric = isNumeric;
        this.sortingGUI = null;
    }

    // Getters para campos imutáveis
    public java.util.List<String> elements() {
        return elements;
    }

    public String typeOrder() {
        return typeOrder;
    }

    public int skip() {
        return skip;
    }

    public boolean isNumeric() {
        return isNumeric;
    }

    // Getter e Setter para sortingGUI

    public SortingGUI sortingGUI() {
        return sortingGUI;
    }

    public void setSortingGUI(SortingGUI sortingGUI) {
        this.sortingGUI = sortingGUI;
    }
}