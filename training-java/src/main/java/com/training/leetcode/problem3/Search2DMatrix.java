package com.training.leetcode.problem3;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = getRow(matrix, i);
            if (rowCanContainTarget(row, target)) {
                return rowContainsTarget(row, target);
            }
        }
        return false;
    }

    // can be improved by doing binary search vertically and horizontally on the matrix
    private static int[] getRow(int[][] matrix, int i) {
        return matrix[i];
    }

    private static boolean rowCanContainTarget(int[] row, int target) {
        return row[0] <= target && target <= row[row.length - 1];
    }

    private static boolean rowContainsTarget(int[] row, int target) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == target) {
                return true;
            }
        }
        return false;
    }
}
