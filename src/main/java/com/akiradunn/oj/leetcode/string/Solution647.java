package com.akiradunn.oj.leetcode.string;
//647. 回文子串
//已解答
//中等
//相关标签
//相关企业
//提示
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
//回文字符串 是正着读和倒过来读一样的字符串。
//
//子字符串 是字符串中的由连续字符组成的一个序列。
//
//
//
//示例 1：
//
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//示例 2：
//
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//
//提示：
//
//1 <= s.length <= 1000
//s 由小写英文字母组成
public class Solution647 {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                if (checkString(s.substring(i, j+1))) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean checkString(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
