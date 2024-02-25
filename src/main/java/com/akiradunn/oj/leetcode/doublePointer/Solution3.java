package com.akiradunn.oj.leetcode.doublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">...</a>
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int max = 1;
        int i = 1;
        while (i < len) {
            int cur = 1;
            int j = i-1;
            // 备忘录
            Set<Character> memo = new HashSet<>();
            memo.add(s.charAt(i));
            while (j >= 0) {
                if (memo.add(s.charAt(j))) {
                    cur++;
                } else {
                    break;
                }
                j --;
            }
            max = Math.max(cur, max);
            i ++;
        }

        return max;
    }
}
