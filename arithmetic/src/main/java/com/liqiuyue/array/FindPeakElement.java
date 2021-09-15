package com.liqiuyue.array;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * @ClassName: FindPeakElement
 * @Description: 寻找峰值
 * @Author: liqiuyue
 * @Date: 2021-09-15
 */
/**
    峰值元素是指其值严格大于左右相邻值的元素。
    给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

 示例 1：

 输入：nums = [1,2,3,1]
 输出：2
 解释：3 是峰值元素，你的函数应该返回其索引 2。

 示例 2：

 输入：nums = [1,2,1,3,5,6,4]
 输出：1 或 5
 解释：你的函数可以返回索引 1，其峰值元素为 2；
      或者返回索引 5， 其峰值元素为 6。
 */
public class FindPeakElement {


    /*
     * 特殊逻辑: [1],[1,2]
     */
    /**
     * 暴力破万象 查找最大值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                idx = i;
            }
        }
        return idx;
    }
}
