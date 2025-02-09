package org.group4.base;

import org.group4.config.AppConfigs;

/**
 * This interface defines the contract for handling command-line arguments.
 */
public interface IArgumentHandler {

    /**
     * Verifies the command-line arguments.
     * This method should perform necessary checks and throw exceptions if any argument is invalid.
     */
    void verify();

    /**
     * Creates an instance of {@link AppConfigs} based on the command-line arguments.
     *
     * @return An instance of {@link AppConfigs} containing the parsed and validated command-line arguments.
     */
    AppConfigs createAppConfigs();
}