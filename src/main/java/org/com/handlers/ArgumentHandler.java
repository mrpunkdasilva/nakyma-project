package org.com.handlers;

import org.com.config.AppConfigs;
import org.com.base.IArgumentHandler;
import org.com.utils.GenerateList;
import org.com.values.Texts;
import org.com.utils.Mercury;

import java.util.List;

/**
 * This class is responsible for handling command-line arguments and validating them.
 * It implements the {@link IArgumentHandler} interface.
 */
public class ArgumentHandler implements IArgumentHandler {

    private final Mercury mercury = new Mercury();
    private final GenerateList generateList = new GenerateList();
    private final ValidateHandler validate = new ValidateHandler();
    private final String[] entryArguments;

    /**
     * Constructor for the ArgumentHandler class.
     *
     * @param entryArguments The command-line arguments provided when running the program.
     */
    public ArgumentHandler(String[] entryArguments) {
        this.entryArguments = entryArguments;
    }

    /**
     * This method verifies the validity of the command-line arguments.
     * It checks each argument against the validation rules defined in the {@link ValidateHandler} class.
     * If any argument fails validation, an error message is displayed using the {@link Mercury} class.
     */
    @Override
    public void verify() {
        if (!validate.validadeQuantityMinimumArgument(entryArguments)) {
            mercury.showError(Texts.ERR_QUANTI_MIN_ARGS.getText());
        }

        if (!validate.validateTypeSortAlgorithm(getArgumentByKey("a"))) {
            mercury.showError(Texts.ERR_SORT_ALGO.getText());
        }

        if (!validate.validateTypeList(getArgumentByKey("t"))) {
            mercury.showError(Texts.ERR_TYPE_LIST.getText());
        }

        if (!validate.validateSortingOrder(getArgumentByKey("o"))) {
            mercury.showError(Texts.ERR_ORDER.getText());
        }

        String inputSource = getArgumentByKey("in").isEmpty() ? "r" : getArgumentByKey("in");

        if (!validate.validateSourceListValues(inputSource)) {
            mercury.showError(Texts.ERR_SOURCE_LIST.getText());
        } else {
            switch(inputSource) {
                case "m" -> {
                    if (!validate.validateUserInput(getArgumentByKey("v"), getArgumentByKey("t"))) {
                        mercury.showError(Texts.ERR_INPUT_USER_LIST.getText());
                    }
                }
                case "r" -> {
                    if (!validate.validateLengthList(getArgumentByKey("r"))) {
                        mercury.showError(Texts.ERR_RANDOM_LENGTH_LIST.getText());
                    }
                }
                default -> {
                    mercury.showError(Texts.ERR_SOURCE_LIST.getText());
                }
            }
        }

        if (!validate.validateIterationTime(getArgumentByKey("s"))) {
            mercury.showError(Texts.ERR_ITERATION_TIME.getText());
        }
    }

    /**
     * This method saves the validated command-line arguments into an {@link AppConfigs} object.
     * It extracts the necessary information from the arguments and creates a new AppConfigs object.
     *
     * @return The AppConfigs object containing the validated command-line arguments.
     */
    @Override
    public AppConfigs createAppConfigs() {
        int randomLengthList = getOptionalIntArgumentByKey("r", -1);
        String typeList = getArgumentByKey("t");
        String inputUser;

        if (getArgumentByKey("in").equalsIgnoreCase("m")) {
            inputUser = getArgumentByKey("v");
        } else {
            inputUser = generateList.generate(typeList, randomLengthList);
        }

        InputListHandler inputListHandler = new InputListHandler(inputUser, typeList);
        inputListHandler.handleInput();
        List<String> inputList = inputListHandler.getAsString();

        return new AppConfigs(
                getArgumentByKey("a"),
                typeList,
                getArgumentByKey("o"),
                getArgumentByKey("in"),
                randomLengthList,
                inputList,
                getIntArgumentByKey("s")
        );
    }
    
    /**
     * Retrieves the optional integer value of a specific command-line argument based on its key.
     * If the argument is not found or its value is empty, the default value is returned.
     *
     * @param key The key of the command-line argument to retrieve.
     * @param defaultValue The default value to return if the argument is not found or its value is empty.
     * @return The optional integer value of the specified command-line argument.
     *         If the argument is not found or its value is empty, the default value is returned.
     */
    private int getOptionalIntArgumentByKey(String key, int defaultValue) {
        String argumentValue = getArgumentByKey(key);
        return argumentValue.isEmpty() ? defaultValue : Integer.parseInt(argumentValue);
    }
    
    /**
     * Retrieves the integer value of a specific command-line argument based on its key.
     * This method first calls the {@link #getArgumentByKey(String)} method to obtain the value of the specified key.
     * Then, it attempts to parse the obtained value as an integer using {@link Integer#parseInt(String)}.
     *
     * @param key The key of the command-line argument to retrieve.
     * @return The integer value of the specified command-line argument.
     *         If the argument is not found or its value cannot be parsed as an integer,
     *         this method will throw a {@link NumberFormatException}.
     * @throws NumberFormatException If the argument is not found or its value cannot be parsed as an integer.
     */
    private int getIntArgumentByKey(String key) {
        return Integer.parseInt(getArgumentByKey(key));
    }

    /**
     * This method retrieves the value of a specific command-line argument based on its key.
     *
     * @param key The key of the command-line argument to retrieve.
     * @return The value of the specified command-line argument. If the argument is not found, an empty string is returned.
     */
    public String getArgumentByKey(String key) {
        String[] listSplitArguments;
        String foundArgument;
        foundArgument = "";

        for (String argument : this.entryArguments) {
            listSplitArguments = argument.split(Texts.EQUALS.getText());

            if (listSplitArguments[0].equalsIgnoreCase(key)) {
                foundArgument = listSplitArguments[1];
            }
        }

        return foundArgument;
    }
}
