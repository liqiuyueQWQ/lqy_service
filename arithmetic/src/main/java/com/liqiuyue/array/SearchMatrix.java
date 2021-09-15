package com.liqiuyue.array;

/**
 * @ClassName: SearchMatrix
 * @Description: 搜索二维矩阵
 * @Author: liqiuyue
 * @Date: 2021-03-30
 */
/*
    每行的所有元素从左到右升序排列
    每列的所有元素从上到下升序排列
    搜索目标值
*/

public class SearchMatrix {

    // 暴力枚举法
    public boolean enumeration(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从右上角开始
    public  boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length -1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else{
                col--;
            }
        }
        return false;
    }
}
