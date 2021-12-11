package com.liqiuyue.sort;

import org.jetbrains.annotations.NotNull;

/**
 * @Description: 选择排序
 * @Author: liqiuyue
 * @Date: 2021-12-07 23:13
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        // i 循环的次数 j 从下标1开始
        for (int i = 1; i < arr.length; i++) {
            int idx = 0;
            // arr.length -i+1处下标已被选择出来
            // 当前循环最大下标为 arr.length-i
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[idx] < arr[j]) {
                    idx = j;
                }
            }
            if(idx != arr.length -i){
                int tmp = arr[idx];
                arr[idx] = arr[arr.length - i];
                arr[arr.length - i] = tmp;
            }
        }
        showArray(arr);
    }

    public static void showArray(@NotNull int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
