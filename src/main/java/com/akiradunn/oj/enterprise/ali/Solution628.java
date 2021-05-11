package com.akiradunn.oj.enterprise.ali;
import java.util.Arrays;
//628. 三个数的最大乘积
//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：6
//示例 2：
//
//输入：nums = [1,2,3,4]
//输出：24
//示例 3：
//
//输入：nums = [-1,-2,-3]
//输出：-6
//
//
//提示：
//
//3 <= nums.length <= 104
//-1000 <= nums[i] <= 1000
//通过次数72,288提交次数138,385
public class Solution628 {
    class Solution {
        public int maximumProduct(int[] nums) {
            //三正
            Arrays.sort(nums);
            int n = nums.length;
            //全正or全负
            int type1 = nums[n-3] * nums[n-2] * nums[n-1];

            if(nums[0] >=0 || nums[n-1] <= 0){
                return type1;
            }
            //两个负数, 一个正数
            int type2 = nums[0] * nums[1] * nums[n-1];
            //一个负数, 两个正数
            int type3 = nums[0] * nums[n-2] * nums[n-1];
            return Math.max(Math.max(type1, type2), type3);
        }
    }
}
