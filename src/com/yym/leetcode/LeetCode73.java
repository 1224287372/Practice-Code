package com.yym.leetcode;

public class LeetCode73 {

    public int[][] run(int[][] matrix) {
        new Solution().setZeroes(matrix);
        return matrix;
    }

    class Solution {
        /**
         * 空间复杂度m+n
         *
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = 0;
            if (n > 0) {
                m = matrix[0].length;
            } else {
                return;
            }
            int[] x = new int[n];
            int[] y = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        x[i] = 1;
                        y[j] = 1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (x[i] == 1 || y[j] == 1) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        /**
         * 空间复杂度O(1)
         *
         * @param matrix
         */
        public void setZeroes2(int[][] matrix) {
            //将第一行和第一列作为标识符
            //先判断第一行和第一列是否有0
            boolean row0_flag = false;
            boolean col0_flag = false;
            int n = matrix.length;
            int m = 0;
            if (n > 0) {
                m = matrix[0].length;
            } else {
                return;
            }
            //判断第一行是否有0
            for (int i = 0; i < m; i++) {
                if (matrix[0][i] == 0) {
                    row0_flag = true;
                    break;
                }
            }
            //判断第一列是否有0
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) {
                    col0_flag = true;
                    break;
                }
            }
            //将初始化第一行和第一列
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            //开始根据表示填零
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //补充第一行
            if (row0_flag) {
                for (int i = 0; i < m; i++) {
                    matrix[0][i] = 0;
                }
            }
            //补充第一列
            if (col0_flag) {
                for (int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
