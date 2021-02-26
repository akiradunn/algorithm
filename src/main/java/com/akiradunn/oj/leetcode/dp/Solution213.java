package com.akiradunn.oj.leetcode.dp;
//213. 打家劫舍 II
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
//给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
//
//
//
//示例 1：
//
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//示例 2：
//
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//示例 3：
//
//输入：nums = [0]
//输出：0
//
//
//提示：
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 1000
public class Solution213 {
    class Solution {
        public int rob(int[] nums) {
            int[] f = new int[nums.length+1];
            int len = nums.length;
            if(len == 0){
                return 0;
            }
            if(len == 1){
                return nums[0];
            }
            f[0] = 0;
            f[1] = nums[0];
            f[2] = Math.max(nums[0], nums[1]);
            //将问题分为两种情况, Math.max(选了第一个没选最后一个, 选了第二个选了最后一个);
            for(int i=2; i<=len; i++){
                f[i] = Math.max(findMax(nums, 0, i-2), findMax(nums, 1, i-1));
            }
            return f[len];
        }

        //1.dp与树完全一致,可以根据子树解求解当前树的解
        //2.看问题必须用树的递归算法思维看问题,用子树的解求解当前解,不能过于纠结细节实现
        public int findMax(int[] nums, int l, int r){
            int len = r - l + 1;
            if(len == 0){
                return 0;
            }
            if(len == 1){
                return nums[l];
            }
            int[] f = new int[len+1];
            f[0] = 0;
            f[1] = nums[l];
            f[2] = Math.max(nums[l], nums[l+1]);
            for(int i=2; i<=len; i++){
                f[i] = Math.max(f[i-1], f[i-2] + nums[l+i-1]);
            }
            return f[len];
        }
    }
}
