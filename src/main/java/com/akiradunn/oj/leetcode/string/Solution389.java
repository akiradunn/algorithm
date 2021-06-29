package com.akiradunn.oj.leetcode.string;
//389. 找不同
//给定两个字符串 s 和 t，它们只包含小写字母。
//
//字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
//请找出在 t 中被添加的字母。
//
//
//
//示例 1：
//
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
//示例 2：
//
//输入：s = "", t = "y"
//输出："y"
//示例 3：
//
//输入：s = "a", t = "aa"
//输出："a"
//示例 4：
//
//输入：s = "ae", t = "aea"
//输出："a"
//
//
//提示：
//
//0 <= s.length <= 1000
//t.length == s.length + 1
//s 和 t 只包含小写字母
//通过次数92,466提交次数133,295
public class Solution389 {
    class Solution {
        public char findTheDifference(String s, String t) {
            char[] sCharArray = s.toCharArray();
            char[] tCharArray = t.toCharArray();
            int sSum = 0;
            int tSum = 0;
            for(int i=0; i<sCharArray.length; i++){
                sSum += sCharArray[i];
            }
            for(int i=0; i<tCharArray.length; i++){
                tSum += tCharArray[i];
            }
            return (char)(tSum-sSum);
        }
    }
}
