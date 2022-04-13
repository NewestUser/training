package com.training.other;

import java.util.*;

class BracketValidationAndGeneration {

    private static final Map<Character, Character> bracketPairs = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    /**
     * This method will generate all valid possible bracket combinations given the length of the desired resulting string.
     *
     * @param length the length of each resulting permutation.
     * @return valid bracket permutations.
     */
    List<String> generateAllPossiblePermutations(int length) {
        // TODO: implement this using validateSyntax
        return new ArrayList<>();
    }

    /**
     * Validate if the provided string has a valid bracket syntax.
     * A string can be considered as valid if all the opening brackets
     * are closed and the brackets are closed in the correct order.
     * The string does not contain characters different than brackets.
     * <pre>
     * Example valid syntax:
     * 1. {{}}
     * 2. []{}
     * 3. (){[]}
     * 4.{[()]}
     * </pre>
     *
     * <pre>
     * Example invalid syntax:
     * 1. {
     * 2. [}
     * 3. {(}
     * 4. [[[
     * </pre>
     *
     * @param syntax the syntax which should be validated.
     * @return true if it is valid, false otherwise.
     */
    static boolean validateSyntax(String syntax) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : syntax.toCharArray()) {

            if (isOpening(bracket)) {
                stack.push(bracket);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character previousBracket = stack.pop();

                if (!isOfSameType(previousBracket, bracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpening(Character bracket) {
        return bracketPairs.containsKey(bracket);
    }

    private static boolean isOfSameType(Character openingBracket, Character closingBracket) {
        Character character = bracketPairs.get(openingBracket);

        return closingBracket.equals(character);
    }

}
