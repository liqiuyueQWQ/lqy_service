package com.liqiuyue.array;

/**
 * @ClassName: MoveZeros
 * @Description: 移动0
 * @Author: liqiuyue
 * @Date: 2021-03-30
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int idx =0 ;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

}
