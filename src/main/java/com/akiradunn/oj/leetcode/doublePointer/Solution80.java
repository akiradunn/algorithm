package com.akiradunn.oj.leetcode.doublePointer;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 *
 * @link <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Solution80 {
    public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        while(i < result) {
            if (i <= 1) {
                i++;
                continue;
            }

            while (true) {
                int cur = nums[i];
                int pre = nums[i-1];
                int prepre = nums[i-2];
                if (cur == pre && pre == prepre) {
                    // 触发移动
                    if (i == result) {
                        break;
                    }
                    result = moveArray(nums, result, i);
                } else {
                    break;
                }
            }

            i++;
        }

        return result;
    }

    public static int moveArray(int[] nums, int limit, int start) {

        if (start == nums.length - 1) {
            return limit - 1;
        }

        int moveStart = start;
        for(int i=start; i<limit; i++) {
            if (nums[i] == nums[i-1]) {
                moveStart ++;
            } else {
                break;
            }
        }
        int result = limit - (moveStart - start);

        if (moveStart >= limit || moveStart >= nums.length) {
            return result;
        }

        for(int i=start; i<nums.length; i++) {
            if (i < nums.length - 1)  {
                nums[i] = nums[moveStart++];
            }

            if (moveStart == nums.length) {
                break;
            }
        }

        return result;
    }
}
