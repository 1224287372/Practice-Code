package com.yym.leetcode;

public class Offer04 {

    public boolean run(int[][] matrix, int target) {
        return new Solution().findNumberIn2DArray(matrix, target);
    }

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int n = matrix.length;
            if (n <= 0) {
                return false;
            }
            int m = matrix[0].length;
            int row = 0, col = m - 1;
            while (row < n && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }
            return false;
        }

    }
}
