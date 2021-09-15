package com.liqiuyue.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TwoSum
 * @Description: 两数之和
 * @Author: liqiuyue
 * @Date: 2021-03-30
 */
public class TwoSum {

    // 暴力枚举
    public int[] enumeration(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 通过hash计算
    public int[] hash(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (hashMap.containsKey(target-nums[i])) {
                    return new int[]{hashMap.get(target-nums[i]),i};
                }
                hashMap.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
