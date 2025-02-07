package org.group4.config;

import java.util.List;

/**
 * This record represents the application's configuration settings.
 *
 * @param a A string parameter representing a specific configuration value.
 * @param typeList A string parameter representing the type of list.
 * @param o A string parameter representing a specific configuration value.
 * @param in A string parameter representing a specific configuration value.
 * @param r An integer parameter representing a specific configuration value.
 * @param inputList A list of strings representing input values.
 * @param s An integer parameter representing a specific configuration value.
 */
public record AppConfigs(String a, String typeList, String o, String in, int r, List<String> inputList, int s) {
}