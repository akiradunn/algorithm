package com.akiradunn.oj.leetcode.array;
import java.util.Arrays;
//169. 多数元素
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
//示例 1：
//
//输入：[3,2,3]
//输出：3
//示例 2：
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//进阶：
//
//尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//通过次数326,528提交次数493,722
public class Solution169 {
    class Solution {
        public int majorityElement(int[] nums) {
            if(nums.length == 1) return nums[0];
            int target = nums.length % 2 == 0 ? nums.length/2 : nums.length/2+1;
            Arrays.sort(nums);
            int elementOccurTimes = 1;
            for(int i=0; i<nums.length-1; i++){
                if(nums[i] == nums[i+1]){
                    elementOccurTimes = elementOccurTimes + 1;
                }else{
                    elementOccurTimes = 1;
                }
                if(elementOccurTimes >= target){
                    return nums[i];
                }
            }
            return -1;
        }
    }
}
