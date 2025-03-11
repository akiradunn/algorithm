package com.akiradunn.oj.leetcode.doublePointer;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 > n1) {
            return -1;
        }

        int slow = 0;
        int fast = 0;
        while (slow < n1 && fast < n2) {
            int i = slow;

            // 循环一直找对的数
            while (i < n1 && fast < n2 && haystack.charAt(i) == needle.charAt(fast)) {
                i++;
                fast++;
            }

            if (fast == n2) {
                break;
            }

            slow++;
            fast = 0;
        }

        if (fast == n2) {
            return slow;
        } else {
            return -1;
        }
    }

}
