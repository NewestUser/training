package com.training.euler.problem1;

class Multiples {

    /**
     * Return the sum of the numbers that are multiple of 3 or 5.
     *
     * @param i the number to check against.
     * @return sum of multiples.
     */
    static int of3or5(int i) {
        int sum = 0;
        while (i >= 3) {
            i--;
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
