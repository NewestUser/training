package com.training.euler.problem3;

class LargestPrimeFactor {

    static long largestPrimeFactorOf(long value) {
        if (value < 2) {
            return 1;
        }
        long factor = 2;
        long quotient = value;

        while (factor < quotient) {
            if (quotient % factor != 0) {
                factor++;
                continue;
            }

            quotient = quotient / factor;
        }

        return factor;
    }
}
