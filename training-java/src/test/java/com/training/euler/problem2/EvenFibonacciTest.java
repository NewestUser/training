package com.training.euler.problem2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenFibonacciTest {

    @Test
    public void fibonacci() {
        assertEquals(1, EvenFibonacci.fibonacci(1));
        assertEquals(1, EvenFibonacci.fibonacci(2));
        assertEquals(2, EvenFibonacci.fibonacci(3));
        assertEquals(3, EvenFibonacci.fibonacci(4));
        assertEquals(5, EvenFibonacci.fibonacci(5));
        assertEquals(8, EvenFibonacci.fibonacci(6));
        assertEquals(13, EvenFibonacci.fibonacci(7));
        assertEquals(21, EvenFibonacci.fibonacci(8));
        assertEquals(34, EvenFibonacci.fibonacci(9));
        assertEquals(55, EvenFibonacci.fibonacci(10));
    }

    @Test
    public void closestInputToGivenFibonacciNumber() {
        assertEquals(2, EvenFibonacci.closestFibonacciInput(1));
        assertEquals(3, EvenFibonacci.closestFibonacciInput(2));
        assertEquals(4, EvenFibonacci.closestFibonacciInput(3));
        assertEquals(5, EvenFibonacci.closestFibonacciInput(5));
        assertEquals(6, EvenFibonacci.closestFibonacciInput(8));
        assertEquals(7, EvenFibonacci.closestFibonacciInput(13));
        assertEquals(8, EvenFibonacci.closestFibonacciInput(21));
        assertEquals(9, EvenFibonacci.closestFibonacciInput(34));
        assertEquals(10, EvenFibonacci.closestFibonacciInput(55));

        assertEquals(33, EvenFibonacci.closestFibonacciInput(4_000_000));
    }

    @Test
    public void sumOfEvenFibonacciNumbers() {
        assertEquals(10, EvenFibonacci.sumOfEvenFibonacci(6));
        assertEquals(44, EvenFibonacci.sumOfEvenFibonacci(9));
        assertEquals(4_613_732, EvenFibonacci.sumOfEvenFibonacci(33));

        assertEquals(10, EvenFibonacci.sumOfEvenFibonacciRecursive(6));
        assertEquals(44, EvenFibonacci.sumOfEvenFibonacciRecursive(9));
        assertEquals(4_613_732, EvenFibonacci.sumOfEvenFibonacciRecursive(33));
    }
}