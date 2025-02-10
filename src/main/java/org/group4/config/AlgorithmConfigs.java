package org.group4.config;

/**
 * Represents the configuration settings for an algorithm.
 *
 * @param elements A list of elements to be processed by the algorithm.
 * @param typeOrder A string representing the order of data types to be considered.
 * @param skip An integer representing the number of elements to skip during processing.
 * @param isNumeric A boolean indicating whether the elements are numeric or not.
 */
public record AlgorithmConfigs(java.util.List<String> elements, String typeOrder, int skip, boolean isNumeric) {
}