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

    /**
     * 首先将数组排序。
     *
     * 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。
     *
     * 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
     *
     * 综上，我们在给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。
     * @param nums
     * @return
     */
//    public int maximumProduct(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
//    }

    /**
     * 在方法一中，我们实际上只要求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数
     * @param nums
     * @return
     */
//    public int maximumProduct(int[] nums) {
//        // 最小的和第二小的
//        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        // 最大的、第二大的和第三大的
//        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
//
//        for (int x : nums) {
//            if (x < min1) {
//                min2 = min1;
//                min1 = x;
//            } else if (x < min2) {
//                min2 = x;
//            }
//
//            if (x > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = x;
//            } else if (x > max2) {
//                max3 = max2;
//                max2 = x;
//            } else if (x > max3) {
//                max3 = x;
//            }
//        }
//
//        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
//    }
}
