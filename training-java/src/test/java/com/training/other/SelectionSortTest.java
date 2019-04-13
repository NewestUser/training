package com.training.other;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SelectionSortTest {

    @Test
    public void doubleEndedSort() {
        int[] unsortedArray = new int[]{2, 8, 5, 3, 9, 4, 1};

        int[] actual = SelectionSort.doubleEndedSort(unsortedArray);

        int[] expectedArray = new int[]{1, 2, 3, 4, 5, 8, 9};

        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actual));
    }

    @Test
    public void doubleEndedSortCase2() {
        int[] unsortedArray = new int[]{2, 8, -3, 5, 3, 15, 9, 4, 1, 6};

        int[] actual = SelectionSort.doubleEndedSort(unsortedArray);

        int[] expectedArray = new int[]{-3, 1, 2, 3, 4, 5, 6, 8, 9, 15};

        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actual));
    }
}