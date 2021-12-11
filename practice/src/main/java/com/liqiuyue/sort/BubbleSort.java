package com.liqiuyue.sort;

/**
 * @Description: 冒泡排序
 * @Author: liqiuyue
 * @Date: 2021-12-07 23:08
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        // 依次比较相邻的两个数，将比较小的数放在前面，比较大的数放在后面
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length -i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
