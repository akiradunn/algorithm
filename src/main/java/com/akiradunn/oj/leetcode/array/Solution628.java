package com.akiradunn.oj.leetcode.array;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 *
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/description/">...</a>
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int result = Integer.MIN_VALUE;
        // 外层 for + 内层双指针进而分类讨论直接计算结果
        for (int i=0; i<nums.length-2; i++) {
            int j = i+1;
            int k = nums.length - 1;
            if (nums[i] < 0) {
                if (nums[k] < 0) {
                    result = Math.max(result, nums[i] * nums[k-1] * nums[k]);
                } else if (nums[k] == 0) {
                    result = Math.max(result, 0);
                } else {
                    if (nums[j] < 0) {
                        result = Math.max(result, nums[i] * nums[j] * nums[k]);
                    } else if (nums[j] == 0) {
                        result = Math.max(result, 0);
                    } else {
                        result = Math.max(result, nums[i] * nums[j] * nums[j+1]);
                    }
                }
            } else if (nums[i] == 0) {
                result = Math.max(result, 0);
            } else {
                result = Math.max(result, nums[k-2] * nums[k-1] * nums[k]);
                break;
            }
        }
        return result;
    }

    /**
     * 纯暴力 会超时
     * @param nums
     * @return
     */
//    public int maximumProduct(int[] nums) {
//        Arrays.sort(nums);
//        int result = Integer.MIN_VALUE;
//        for (int i=0; i<nums.length-2; i++) {
//            for (int j=i+1; j<nums.length-1; j++) {
//                for (int k=j+1; k<nums.length; k++) {
//                    result = Math.max(result, nums[i] * nums[j] * nums[k]);
//                }
//            }
//        }
//        return result;
//    }
}
