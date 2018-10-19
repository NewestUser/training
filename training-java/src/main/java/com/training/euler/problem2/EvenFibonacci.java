package com.training.euler.problem2;

class EvenFibonacci {

    static int fibonacci(int i) {

        if (i <= 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }

        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    static int closestFibonacciInput(int fibonacciTerm) {

        int i = 0;
        while (true) {

            int fibonacci = EvenFibonacci.fibonacci(i);
            if (fibonacci > fibonacciTerm) {
                return i - 1;
            }
            i++;
        }

    }

    static int sumOfEvenFibonacci(int i) {

        int sum = 0;
        for (int j = 0; j <= i; j++) {
            int fibonacci = fibonacci(j);

            sum += fibonacci % 2 == 0 ? fibonacci : 0;
        }


        return sum;
    }

    static int sumOfEvenFibonacciRecursive(int i) {
        return sumOfFibonacci(i, 0);
    }

    private static int sumOfFibonacci(int i, int sum) {

        if (i == 0) {
            return sum;
        }

        int fibonacci = fibonacci(i);
        if (fibonacci % 2 == 0) {
            sum += fibonacci;
        }

        return sumOfFibonacci(i - 1, sum);
    }
}
