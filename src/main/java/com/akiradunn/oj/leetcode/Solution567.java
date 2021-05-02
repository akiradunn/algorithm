package com.akiradunn.oj.leetcode;
import java.util.Arrays;
//567. 字符串的排列
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
//
//
//
//示例 1：
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//示例 2：
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//提示：
//
//输入的字符串只包含小写字母
//两个字符串的长度都在 [1, 10,000] 之间
//通过次数83,944提交次数199,056
public class Solution567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            if(m < n) return false;
            char[] charArray1 = s1.toCharArray();
            char[] charArray2 = s2.toCharArray();
            //s2字符串中有长度为n的字串中, 各个字符的计数都与s1一致, 则认为s2字符串包含s1的排列
            int[] array1 = new int[26];
            int[] array2 = new int[26];
            for(int i=0; i<n; i++){
                ++array1[charArray1[i]-'a'];
                ++array2[charArray2[i]-'a'];
            }

            if(Arrays.equals(array1, array2)){
                return true;
            }

            for(int i=n; i<m; i++){
                --array2[charArray2[i-n] - 'a'];
                ++array2[charArray2[i] - 'a'];
                if(Arrays.equals(array1, array2)){
                    return true;
                }
            }

            return false;
        }
    }
}
