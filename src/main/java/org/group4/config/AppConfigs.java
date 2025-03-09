package org.group4.config;

import java.util.List;

// TODO: DESCREVER ESSES PARAMETROS DA CONFIGURAÇÃO
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
      public String getAlgorithmName() {
        if (a.equalsIgnoreCase("b")) {
            return "Bubble Sort";
        } else {
            if (a.equalsIgnoreCase("s")) return "Selection Sort";
            return "Quick Sort";
        }
    }

    public String getTypeListName() {
        return typeList.equalsIgnoreCase("c")? "Caracter" : "Inteiro";
    }
    public String getSortAlgorithm() { return a; }
    public String getTypeList() { return typeList; }
    public String getSortingOrder() { return o; }
    public String getSourceList() { return in; }
    public int getRandomLengthList() { return r; }
    public List<String> getInputList() { return inputList; }
    public int getIterationTime() { return s; }
}