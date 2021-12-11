package com.liqiuyue.sort;

/**
 * @Description: 反转排序
 * @Author: liqiuyue
 * @Date: 2021-12-11 15:11
 **/
public class ReverseSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length -1- i];
            arr[arr.length - 1 - i] = tmp;
        }
        SelectionSort.showArray(arr);
    }
}
