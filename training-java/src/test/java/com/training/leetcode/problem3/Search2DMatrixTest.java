package com.training.leetcode.problem3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Search2DMatrixTest {

    @Test
    public void squareMatrix() {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        assertTrue(Search2DMatrix.searchMatrix(matrix, 3));
        assertFalse(Search2DMatrix.searchMatrix(matrix, 13));
    }
}