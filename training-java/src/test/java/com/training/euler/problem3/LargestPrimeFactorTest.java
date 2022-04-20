package com.training.euler.problem3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestPrimeFactorTest {

    @Test
    public void largestPrimeFactor() {
        assertEquals(1, LargestPrimeFactor.largestPrimeFactorOf(1));
        assertEquals(5, LargestPrimeFactor.largestPrimeFactorOf(10));
        assertEquals(3, LargestPrimeFactor.largestPrimeFactorOf(24));
        assertEquals(17 , LargestPrimeFactor.largestPrimeFactorOf(17));
        assertEquals(11L, LargestPrimeFactor.largestPrimeFactorOf(11L));
        assertEquals(3, LargestPrimeFactor.largestPrimeFactorOf(12));
        assertEquals(29, LargestPrimeFactor.largestPrimeFactorOf(13195));
        assertEquals(6857L, LargestPrimeFactor.largestPrimeFactorOf(600851475143L));
    }
}