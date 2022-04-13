package com.training.leetcode.problem2;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer; in other words, it is the product
 * of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * <p>
 * Constraints:
 * 1 <= n <= 104
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int count = 0;

        int base = n / 2;
        int baseSquared = powOf2(base);

        if (baseSquared == n) {
            return 1;
        }

        return -1;
    }


    private int powOf2(int value) {
        return value * value;
    }
}
