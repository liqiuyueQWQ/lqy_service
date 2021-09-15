package com.liqiuyue.array;

import java.util.Arrays;

/**
 * @ClassName: KthSmallest
 * @Description: 有序矩阵中第K的小元素
 * @Author: liqiuyue
 * @Date: 2021-03-30
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length,m=matrix[0].length;
        int[] num = new int[n*m];
//
//        int idx = 0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                num[idx++] = matrix[i][j];
//            }
//        }
        int idx = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                num[idx++] = anInt;
            }
        }
        Arrays.sort(num);
        return num[k-1];
    }
}
