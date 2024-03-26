package com.akiradunn.oj.leetcode.array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/">...</a>
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0,0};
            } else {
                return new int[]{-1,-1};
            }
        } else if (nums.length == 2) {
            if (nums[0] == target && nums[1] == target) {
                return new int[]{0,1};
            } else if (nums[0] == target) {
                return new int[]{0,0};
            } else if (nums[1] == target) {
                return new int[]{1,1};
            } else {
                return new int[]{-1,-1};
            }
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int low = mid;
                int high = mid;
                while(low >= 0) {
                    if (nums[low] == target) {
                        low--;
                    } else {
                        break;
                    }
                }
                while(high < nums.length) {
                    if (nums[high] == target) {
                        high++;
                    } else {
                        break;
                    }
                }
                return new int[]{low+1, high-1};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
