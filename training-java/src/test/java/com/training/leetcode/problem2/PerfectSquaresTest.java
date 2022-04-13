package com.training.leetcode.problem2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfectSquaresTest {

    @Test
    public void test0() {
        var result = new PerfectSquares().numSquares(4);
        assertEquals(result, 1); // 2^2
    }

    @Test
    public void test1() {
        var result = new PerfectSquares().numSquares(12);
        assertEquals(result, 3); // 2^2 + 2^2 + 2^2
    }

    @Test
    public void test2() {
        var result = new PerfectSquares().numSquares(13);
        assertEquals(result, 2); // 2^2 + 3^3
    }
}