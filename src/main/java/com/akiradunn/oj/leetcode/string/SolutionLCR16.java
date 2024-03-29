package com.akiradunn.oj.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * LCR 016. 无重复字符的最长子串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 *
 * 注意：本题与主站 3 题相同： <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">...</a>
 */
public class SolutionLCR16 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 1;
        for (int i=1; i< s.length(); i++) {
            int j = i - 1;
            Set<Character> meno = new HashSet<>();
            meno.add(s.charAt(i));
            while (j >= 0) {
                char charAt = s.charAt(j);
                if (meno.contains(charAt)) {
                    break;
                }
                meno.add(charAt);
                j --;
            }
            result = Math.max(result, i - (j+1) + 1);
        }

        return result;
    }
}
