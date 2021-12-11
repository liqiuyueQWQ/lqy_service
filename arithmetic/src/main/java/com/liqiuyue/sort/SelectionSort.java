package com.liqiuyue.sort;

/**
 * @Description: 选择排序
 * @Author: liqiuyue
 * @Date: 2021-12-07 23:13
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        for (int i = 1; i < arr.length; i++) {
            int idx = 0;
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int temp = arr[arr.length - i];
            arr[arr.length - i] = arr[idx];
            arr[idx] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
