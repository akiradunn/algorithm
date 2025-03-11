package com.akiradunn.oj.leetcode.array;

import java.util.*;

/**
 * LCR 007. 三数之和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * <a href="https://leetcode.cn/problems/1fGaJU/description/">...</a>
 */
public class SolutionLCR007 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        List<List<Integer>> result = new ArrayList<>();
//        Set<String> meno = new HashSet<>();
//        for (int i = 0; i < len - 2; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            for (int j = i + 1; j < len - 1; j++) {
//                if (nums[i] + nums[j] > 0) {
//                    break;
//                }
//                for (int k = j + 1; k < len; k++) {
//                    if (nums[i] + nums[j] + nums[k] > 0) {
//                        break;
//                    }
//                    String key = genKey(nums[i], nums[j], nums[k]);
//                    if (nums[i] + nums[j] + nums[k] == 0 && !meno.contains(key)) {
//                        List<Integer> item = new ArrayList();
//                        item.add(nums[i]);
//                        item.add(nums[j]);
//                        item.add(nums[k]);
//                        meno.add(key);
//                        result.add(item);
//                    }
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 双指针版本
     * ps：双指针与快慢指针的区别是指针初始位置与移动方向不一致，
     * 区别：
     *  双指针：左右，向中间移动
     *  快慢指针：同时在左或者右边往，往右或者左移动
     * 联系：
     *  均适用于排序后的数组的元素选取逻辑
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Set<String> meno = new HashSet<>();
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            int j = i + 1;
            int k = len -1;
            while (j < k) {
                if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else {
                    String key = genKey(nums[i], nums[j], nums[k]);
                    if (!meno.contains(key)) {
                        List<Integer> item = new ArrayList();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        meno.add(key);
                        result.add(item);
                        j ++;
                        k --;
                    }
                }
            }
        }
        return result;
    }

    public String genKey(int a, int b, int c) {
        return a + "-" + b + "-" + c;
    }
}
