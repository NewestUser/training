package com.training.leetcode.problem4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntegerTest {

    @Test
    public void reverseInt() {
        assertEquals(321, ReverseInteger.reverse(123));
        assertEquals(-321, ReverseInteger.reverse(-123));
        assertEquals(21, ReverseInteger.reverse(120));
        assertEquals(0, ReverseInteger.reverse(2147483647)); // overflow
        assertEquals(0, ReverseInteger.reverse(1534236469)); // overflow
    }
}