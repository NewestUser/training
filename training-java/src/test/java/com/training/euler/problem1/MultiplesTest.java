package com.training.euler.problem1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplesTest {

    @Test
    public void multiplesOf3or5() {

        assertEquals(23, Multiples.of3or5(10));
//        assertEquals(233168, Multiples.of3or5(1000));
    }
}