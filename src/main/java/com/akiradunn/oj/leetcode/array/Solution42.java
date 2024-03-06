package com.akiradunn.oj.leetcode.array;

/**
 * 42. 接雨水
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * <a href="https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Solution42 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /**
     * 对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]
     */
    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i=0; i<height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            // i 右边找最大值
            int j = i+1;
            while (j < height.length) {
                rightMax[i] = Math.max(rightMax[i], height[j]);
                j ++;
            }
            // i 左边找最大值
            int k = i-1;
            while (k >= 0) {
                leftMax[i] = Math.max(leftMax[i], height[k]);
                k --;
            }
        }

        int result = 0;
        for (int i=1; i<height.length-1; i++) {
            int rainHeight = Math.min(leftMax[i], rightMax[i]);
            if (rainHeight > height[i]) {
                result = result + rainHeight - height[i];
            }
        }
        return result;
    }
}
