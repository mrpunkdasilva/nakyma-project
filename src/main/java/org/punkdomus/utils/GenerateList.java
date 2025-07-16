
package org.punkdomus.utils;

import org.punkdomus.config.Rules;
import org.punkdomus.values.Letters;
import org.punkdomus.values.Numbers;

/**
 * This class is responsible for generating a list of either characters or numbers based on the given parameters.
 */
public class GenerateList {
    private String typeList;
    private int length;
    private StringBuilder sb;

    /**
     * Generates a list of characters or numbers based on the given type and length.
     *
     * @param type The type of elements to be included in the list. It can be either "characters" or "numbers".
     * @param randomLengthList The length of the generated list.
     * @return A string representing the generated list.
     */
    public String generate(String type, int randomLengthList) {
        typeList = type;
        length = randomLengthList;
        sb = new StringBuilder();

        String list = "";

        list = makeList();
        return list;
    }

    /**
     * Determines the type of elements to be included in the list and calls the appropriate generation method.
     *
     * @return A string representing the generated list.
     */
    private String makeList() {
      if (typeList.equalsIgnoreCase(Rules.CHARACTERS.getText())) {
          return generateCharacters();
      } else if (typeList.equalsIgnoreCase(Rules.NUMERIC.getText())){
          return generateNumbers();
      } else {
          return "";
      }
    }

    /**
     * Generates a list of characters based on the specified length.
     *
     * @return A string representing the generated list of characters.
     */
    private String generateCharacters() {
        for (int i = 0; i < length; i++) {
            sb.append(Letters.getRandom());
            if (i != length - 1)  sb.append(",");
        }
        return sb.toString();
    }

    /**
     * Generates a list of numbers based on the specified length.
     *
     * @return A string representing the generated list of numbers.
     */
    private String generateNumbers() {
        for (int i = 0; i < length; i++) {
            sb.append(Numbers.getRandom().getValue());
            if (i!= length - 1)  sb.append(",");
        }
        return sb.toString();
    }
}
