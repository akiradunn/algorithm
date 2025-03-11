package com.akiradunn.oj.leetcode.doublePointer;

/**
 * 633. 平方数之和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 * <a href="https://leetcode.cn/problems/sum-of-square-numbers/description/">...</a>
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        // 双指针
        long l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long a = l * l;
            long b = r * r;
            if (a + b > c) {
                r--;
            } else if (a + b < c) {
                l++;
            } else {
                return true;
            }
        }

        return false;
    }
}
