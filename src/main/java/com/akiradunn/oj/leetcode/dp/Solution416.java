package com.akiradunn.oj.leetcode.dp;
//416. 分割等和子集
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//注意:
//
//每个数组中的元素不会超过 100
//数组的大小不会超过 200
//示例 1:
//
//输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
//
//示例 2:
//
//输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
//
//
//通过次数112,141提交次数225,910
public class Solution416 {
    //此题须有0,1背包问题知识储备;
    //无需知道数组具体挑出了哪些数, 只需定义问题, 判断是否需要选择当前数, 依赖状态转移求解问题
    class Solution {
        public boolean canPartition(int[] nums) {
            if(nums.length < 2) return false;
            int n = nums.length;
            int sum = 0;
            for(int i=0; i<n; i++){
                sum += nums[i];
            }
            //奇数肯定不行
            if((sum & 1) == 1){
                return false;
            }
            int target = sum / 2;
            //定义0-i范围内, 是否有元素和可以满足等于j
            boolean[][] f = new boolean[n][target+1];
            if(nums[0] <= target){
                f[0][nums[0]] = true;
            }
            for(int i=0; i<n; i++){
                f[i][0] = true;
            }
            for(int i=1; i<n; i++){
                for(int j=1; j<=target; j++){
                    //无法放入, 当前元素放入后容量超限
                    if(j < nums[i]){
                        f[i][j] = f[i-1][j];
                    }else{
                        //可以将nums[i]放入当前容量为j的背包时, 考虑要放入还是不放入
                        f[i][j] = f[i-1][j] | f[i-1][j-nums[i]];
                    }
                }
            }
            return f[n-1][target];
        }
    }
}
