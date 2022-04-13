package com.training.other;

/**
 * Calculate the number of possible ways a stairway can be climbed.
 *
 * Example:
 * Given a stairway with 3 stairs and one can either take 1 or 2 stair at a time then there
 * are 3 possible ways the stairs can be climbed.
 * Solution: 1st- 1 step, 1 step, 1 step; 2nd- 1 step, 2 steps; 3th- 2 steps 1 step;
 *
 */
class RecursiveSteps {
    static int numOfWaysGivenOneOrTwoSteps(int stairs) {
        if (stairs <= 1) {
            return 1;
        }
        return numOfWaysGivenOneOrTwoSteps(stairs - 2) + numOfWaysGivenOneOrTwoSteps(stairs - 1);
    }

    static int numOfBottomUpWaysGivenOneOrTwoSteps(int stairs) {
        if (stairs <= 1) {
            return 1;
        }

        int prevOne = 1;
        int ways = 1;

        for (int i = 2; i <= stairs; i++) {
            ways += prevOne;
            prevOne = ways - prevOne;
        }

        return ways;
    }

    static int numOfWaysGivenSteps(int stairs, int[] steps) {
        if (stairs == 0 || stairs == 1) {
            return 1;
        }

        int sum = 0;
        for (int step : steps) {
            if (stairs - step >= 0) {
                sum += numOfWaysGivenSteps(stairs - step, steps);
            }
        }

        return sum;
    }
}
