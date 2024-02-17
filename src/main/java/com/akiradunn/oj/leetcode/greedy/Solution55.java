package com.akiradunn.oj.leetcode.greedy;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 *
 * @link <a href="https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Solution55 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        boolean canJump = canJump(nums);
        System.out.println(canJump);
    }

    /**
     * 贪心思想
     * 收获：一般是先暴力，再剪枝，但是这只是方法论，问题解决必须从本质出发思考
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        // 最远可以到达的位置, 只要最远可到达位置能超过 n-1，即代表是可以跳到最后一个元素的
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

//    public static boolean canJump(int[] nums) {
//        // dp 思想，空间换时间
//        final Map<Integer, Boolean> meno = new HashMap<>();
//        return canJump(nums, 0, MENO);
//    }
//
//    /**
//     * 回溯思想
//     * @return
//     */
//    private static boolean canJump(int[] nums, int curIndex, Map<Integer, Boolean> MENO) {
//        // 刚好跳到最后的位置
//        if (curIndex == nums.length - 1) {
//            MENO.put(curIndex, true);
//            return true;
//        }
//        // 越界情况
//        else if (curIndex > nums.length - 1) {
//            MENO.put(curIndex, false);
//            return false;
//        }
//        // 剪枝，当前元素距离数组最后位置已经够大了，就可以直接跳过去，不用进行后续的递归计算了
//        else if (nums[curIndex] >= (nums.length - 1 - curIndex)) {
//            MENO.put(curIndex, true);
//            return true;
//        }
//        for (int i = 1; i <= nums[curIndex]; i++) {
//            final int jumpToIndex = curIndex + i;
//            Boolean previousJudge = MENO.get(jumpToIndex);
//            if (Objects.isNull(previousJudge)) {
//                previousJudge = canJump(nums, jumpToIndex, MENO);
//                MENO.put(jumpToIndex, previousJudge);
//            }
//
//            if (previousJudge) {
//                MENO.put(curIndex, true);
//                return true;
//            }
//        }
//
//        MENO.put(curIndex, false);
//        return false;
//    }
}
