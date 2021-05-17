package com.akiradunn.oj.enterprise.bytedance;
//42. 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
//示例 1：
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//示例 2：
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//提示：
//
//n == height.length
//0 <= n <= 3 * 104
//0 <= height[i] <= 105
//通过次数246,140提交次数441,164
public class Solution42 {
    //暴力
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int res = 0;
            //两边找
            for(int i=1; i<n-1; i++){
                int maxLeft = 0;
                int maxRight = 0;
                for(int j=i-1; j>=0; j--){
                    maxLeft = Math.max(maxLeft, height[j]);
                }
                for(int k=i+1; k<n; k++){
                    maxRight = Math.max(maxRight, height[k]);
                }
                int minHeight = Math.min(maxLeft, maxRight);
                res += minHeight > height[i] ? (minHeight - height[i]) : 0;
            }
            return res;
        }
    }

    //动态规划优化
    class Solution2 {
        public int trap(int[] height) {
            if(height.length == 0) return 0;
            int n = height.length;
            int res = 0;
            int[] maxLeft = new int[n];
            int[] maxRight = new int[n];
            maxLeft[0] = 0;
            for(int i=1; i<n; i++){
                maxLeft[i] = Math.max(height[i-1], maxLeft[i-1]);
            }
            maxRight[n-1] = 0;
            for(int i=n-2; i>=0; i--){
                maxRight[i] = Math.max(height[i+1], maxRight[i+1]);
            }
            //两边找
            for(int i=0; i<n; i++){
                int minHeight = Math.min(maxLeft[i], maxRight[i]);
                res += minHeight > height[i] ? (minHeight - height[i]) : 0;
            }
            return res;
        }
    }
}
