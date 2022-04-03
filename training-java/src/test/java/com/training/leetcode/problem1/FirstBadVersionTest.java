package com.training.leetcode.problem1;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstBadVersionTest {

    @Test
    public void checkOneVersion() {
        var badVersion = new FirstBadVersion(1).firstBadVersion(1);
        assertEquals(1, badVersion);
    }

    @Test
    public void checkTwoVersion() {
        var badVersion = new FirstBadVersion(1).firstBadVersion(2);
        assertEquals(1, badVersion);

        badVersion = new FirstBadVersion(2).firstBadVersion(2);
        assertEquals(2, badVersion);
    }

    @Test
    public void checkThreeVersions() {
        var badVersion = new FirstBadVersion(1).firstBadVersion(3);
        assertEquals(1, badVersion);

        badVersion = new FirstBadVersion(2).firstBadVersion(3);
        assertEquals(2, badVersion);

        badVersion = new FirstBadVersion(3).firstBadVersion(3);
        assertEquals(3, badVersion);
    }

    @Test
    public void checkRandomBadVersions() {
        var badVersion = new FirstBadVersion(5).firstBadVersion(10);
        assertEquals(5, badVersion);

        badVersion = new FirstBadVersion(10).firstBadVersion(10);
        assertEquals(10, badVersion);

        badVersion = new FirstBadVersion(7).firstBadVersion(23);
        assertEquals(7, badVersion);

    }

    @Test
    public void checkReallyLongBadVersion() {
        var badVersion = new FirstBadVersion(2147483647).firstBadVersion(2147483647);
        assertEquals(2147483647, badVersion);
    }
}