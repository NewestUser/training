package com.training.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursiveStepsTest {

    @Test
    public void numberOfRecursiveWaysToGetUpAStairWithGivenMaxStep() {

        assertEquals(1, RecursiveSteps.numOfWaysGivenOneOrTwoSteps(1));
        assertEquals(2, RecursiveSteps.numOfWaysGivenOneOrTwoSteps(2));
        assertEquals(3, RecursiveSteps.numOfWaysGivenOneOrTwoSteps(3));
        assertEquals(5, RecursiveSteps.numOfWaysGivenOneOrTwoSteps(4));
        assertEquals(8, RecursiveSteps.numOfWaysGivenOneOrTwoSteps(5));
    }

    @Test
    public void numberOfBottomUpWaysToGetUpAStairWithGivenMaxStep() {

        assertEquals(1, RecursiveSteps.numOfBottomUpWaysGivenOneOrTwoSteps(1));
        assertEquals(2, RecursiveSteps.numOfBottomUpWaysGivenOneOrTwoSteps(2));
        assertEquals(3, RecursiveSteps.numOfBottomUpWaysGivenOneOrTwoSteps(3));
        assertEquals(5, RecursiveSteps.numOfBottomUpWaysGivenOneOrTwoSteps(4));
        assertEquals(8, RecursiveSteps.numOfBottomUpWaysGivenOneOrTwoSteps(5));
    }


    @Test
    public void numOfRecursiveWaysToGetUpStairGivenSteps() {

        assertEquals(1, RecursiveSteps.numOfWaysGivenSteps(1, new int[]{1, 2}));
        assertEquals(2, RecursiveSteps.numOfWaysGivenSteps(2, new int[]{1, 2}));
        assertEquals(3, RecursiveSteps.numOfWaysGivenSteps(3, new int[]{1, 2}));
        assertEquals(5, RecursiveSteps.numOfWaysGivenSteps(4, new int[]{1, 2}));
        assertEquals(8, RecursiveSteps.numOfWaysGivenSteps(5, new int[]{1, 2}));

        assertEquals(1, RecursiveSteps.numOfWaysGivenSteps(2, new int[]{1, 3, 5}));
        assertEquals(2, RecursiveSteps.numOfWaysGivenSteps(3, new int[]{1, 3, 5}));
    }
}