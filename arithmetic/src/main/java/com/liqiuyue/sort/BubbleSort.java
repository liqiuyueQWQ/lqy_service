package com.liqiuyue.sort;

/**
 * @Description: 冒泡排序
 * @Author: liqiuyue
 * @Date: 2021-12-07 23:08
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
