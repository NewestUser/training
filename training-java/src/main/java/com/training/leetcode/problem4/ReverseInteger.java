package com.training.leetcode.problem4;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: x = 120
 * Output: 21
 * <p>
 * Constraints:
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public static int reverse(int number) {
        int reversed = 0;
        int quotient = Math.abs(number);
        boolean isNegative = number < 0;

        while (quotient != 0) {
            int remainder = quotient % 10;
            int tmpReversed = reversed * 10 + remainder;
            quotient = quotient / 10;
            if (tmpReversed < 0 || reversed != (tmpReversed - remainder) / 10) { // overflow check
                return 0;
            }
            reversed = tmpReversed;
        }

        if (isNegative) {
            return -reversed;
        }
        return reversed;
    }

}
