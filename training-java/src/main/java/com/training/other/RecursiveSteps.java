package com.training.other;

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
