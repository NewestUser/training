package com.training.leetcode.problem5;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 *
 * <pre>
 *
 * 1. Read in and ignore any leading whitespace.
 *
 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either. This determines if the final result is negative or positive respectively.
 * Assume the result is positive if neither is present.
 *
 * 3. Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 *
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read,
 * then the integer is 0. Change the sign as necessary (from step 2).
 *
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it
 * remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 *
 * 6. Return the integer as the final result.
 * </pre>
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * <pre>
 * <b>Example 1:</b>
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 *
 * <b>Example 2:</b>
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 *
 * <b>Example 3:</b>
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 *
 *
 * <b>Constraints:</b>
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 * </pre>
 */
public class StringToInteger {

    public static int atoi(String str) {
        boolean calculationStarted = false;
        boolean digitExpected = false;
        int sign = 1;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (calculationStarted) {
                    return sign * result;
                }
                if (digitExpected) {
                    return 0;
                }
                continue;
            }
            if (c == '-') {
                if (calculationStarted) {
                    return sign * result;
                }
                if (digitExpected) {
                    return 0;
                }
                digitExpected = true;
                sign = -1;
                continue;
            }
            if (c == '+') {
                if (calculationStarted) {
                    return sign * result;
                }
                if (digitExpected) {
                    return 0;
                }
                digitExpected = true;
                continue;
            }

            if (!Character.isDigit(c)) {
                if (calculationStarted) {
                    break;
                } else if (digitExpected) {
                    return 0;
                } else {
                    break;
                }
            }

            calculationStarted = true;
            int digit = Character.getNumericValue(c);
            int tmpResult = result * 10 + digit;
            if (tmpResult < 0 || (tmpResult - digit) / 10 != result) { // overflow
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result = tmpResult;
        }
        return sign * result;
    }

}
