package com.training.euler.problem3;

class LargestPrimeFactor {

    static long largestPrimeFactorOf(long i) {
        if (i == 1) {
            return 1;
        }

        long largestPrime = i;
        while (largestPrime >= 0) {
            long reminder = i % --largestPrime;

            if (largestPrime == 1) {
                break;
            }

            if (reminder == 0) {
                return largestPrime;
            }
        }

        return i;
    }

}
