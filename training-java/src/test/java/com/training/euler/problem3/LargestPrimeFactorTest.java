package com.training.euler.problem3;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestPrimeFactorTest {

    @Ignore // TODO solve this problem
    @Test
    public void largestPrimeFactor() {
        assertEquals(5, LargestPrimeFactor.largestPrimeFactorOf(10));
        assertEquals(11L, LargestPrimeFactor.largestPrimeFactorOf(11L));
        assertEquals(3, LargestPrimeFactor.largestPrimeFactorOf(12));
        assertEquals(29, LargestPrimeFactor.largestPrimeFactorOf(13195));
        assertEquals(6857L, LargestPrimeFactor.largestPrimeFactorOf(600851475143L));
    }
}