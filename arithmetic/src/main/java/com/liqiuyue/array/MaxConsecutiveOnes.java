package com.liqiuyue.array;

/**
 * @ClassName: MaxConsecutiveOnes
 * @Description: 最大连续1的个数
 * @Author: liqiuyue
 * @Date: 2021-03-30
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int num = 0;
        int max = 0;
        for (int i : nums) {
            num = i == 1 ? num + 1 : 0;
            max = Math.max(max, num);
        }
        return max;
    }

}
