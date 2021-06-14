package com.akiradunn.oj.leetcode.array;

import java.util.Arrays;
//136. 只出现一次的数字
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//说明：
//
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//示例 1:
//
//输入: [2,2,1]
//输出: 1
//示例 2:
//
//输入: [4,1,2,1,2]
//输出: 4
//通过次数417,776提交次数583,889
public class Solution136 {
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for(int i = 0; i < n - 1;i += 2){
                if(nums[i] != nums[i+1]){
                    return nums[i];
                }
            }
            return nums[n-1];
        }
    }
}
