package com.training.leetcode.problem5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToIntegerTest {

    @Test
    public void stringToIntConversion() {
        assertEquals(1, StringToInteger.atoi("1"));
        assertEquals(1, StringToInteger.atoi("  1"));
        assertEquals(1, StringToInteger.atoi("+1"));
        assertEquals(-1, StringToInteger.atoi("-1"));
        assertEquals(1, StringToInteger.atoi(" +1"));
        assertEquals(0, StringToInteger.atoi(" +-1"));
        assertEquals(0, StringToInteger.atoi(" + 1"));
        assertEquals(0, StringToInteger.atoi(" -+1"));
        assertEquals(2147483647, StringToInteger.atoi("2147483648"));
        assertEquals(-42, StringToInteger.atoi("   -42"));
        assertEquals(-42, StringToInteger.atoi("   -0042"));
        assertEquals(4193, StringToInteger.atoi("4193 with words"));
        assertEquals(-2147483648, StringToInteger.atoi("-91283472332")); // clamp overflow
        assertEquals(0, StringToInteger.atoi("00000-42"));
        assertEquals(0, StringToInteger.atoi("00000-42a1234"));
        assertEquals(-12, StringToInteger.atoi("  -0012a42"));
        assertEquals(-88827, StringToInteger.atoi("    -88827   5655  U"));
        assertEquals(-5, StringToInteger.atoi("-5-"));
    }
}