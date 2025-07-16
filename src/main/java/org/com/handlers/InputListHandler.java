package org.com.handlers;

import org.com.config.Rules;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for handling input lists and converting them into either a list of strings or a list of integers.
 * It supports two types of input: "c" for converting to uppercase strings and "n" for converting to integers within a specified range.
 */
public class InputListHandler {

    private  String inputList;
    private  String type;
    private  List<String> listAsString;
    private  List<Integer> listAsInteger;

    /**
     * Default constructor with optional parameters.
     * It initializes empty lists and sets default values.
     */
    public InputListHandler() {
        this("", "c");
    }

    /**
     * Constructs a new InputListHandler instance.
     *
     * @param inputList The input list to be handled.
     * @param type      The type of conversion to be performed. It can be either "c" for converting to uppercase strings or "n" for converting to integers.
     */
    public InputListHandler(String inputList, String type) {
        this.type = type;
        this.inputList = inputList;
        this.listAsInteger = new ArrayList<>();
        this.listAsString = new ArrayList<>();
    }

    /**
     * Handles the input list based on the specified type.
     *
     * @return True if the input list is valid and successfully converted, false otherwise.
     */
    public boolean handleInput() {
        boolean isValid = true;
        for (String item : splitInputList()) {
            if (!manipulateItemList(item)) {
                isValid = false;
            }
        }
        return isValid;
    }

    /**
     * Returns the list of integers after handling the input list.
     *
     * @return The list of integers.
     */
    public List<Integer> getAsIntegers() {
        return this.listAsInteger;
    }

    /**
     * Returns the list of strings after handling the input list.
     *
     * @return The list of strings.
     */
    public List<String> getAsString() {
        return this.listAsString;
    }

    /**
     * Splits the input list into individual items.
     *
     * @return An array of individual items.
     */
    public String[] splitInputList() {
        return inputList.replaceAll("\\s", "").split(",");
    }

    /**
     * Manipulates each item in the input list based on the specified type.
     *
     * @param item The item to be manipulated.
     * @return True if the item is successfully manipulated, false otherwise.
     */
    public boolean manipulateItemList(String item) {
        switch (type) {
            case "c":
                this.listAsString.add(item);
                return true;
            case "n":
                try {
                    int value = Integer.parseInt(item.trim());
                    if (value >= Rules.MIN_VALUE.getInt() && value <= Rules.MAX_VALUE.getInt()) {
                        this.listAsString.add(Integer.toString(value));
                        this.listAsInteger.add(value);
                        return true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            default:
                return false;
        }
    }

    /**
     * Converts a list of strings to an array of integers.
     * @param inputList the list of strings to be converted
     * @return an array of integers
     */
    public Integer[] toIntArray(List<String> inputList) {
        return inputList.stream()
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    /**
     * Converts a list of strings to an array of characters.
     * @param inputList the list of strings to be converted
     * @return an array of characters
     */
    public Character[] toCharArray(List<String> inputList) {
        return inputList.stream()
                .map(str -> str.charAt(0))
                .toArray(Character[]::new);
    }
}
