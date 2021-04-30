package com.akiradunn.oj.leetcode;
import java.util.HashSet;
import java.util.Set;
//3. 无重复字符的最长子串
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//示例 4:
//
//输入: s = ""
//输出: 0
//
//
//提示：
//
//0 <= s.length <= 5 * 104
//s 由英文字母、数字、符号和空格组成
//通过次数969,341提交次数2,616,932
public class Solution3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] charArray = s.toCharArray();
            if(charArray.length ==0) return 0;
            if(charArray.length ==1) return 1;
            int n = charArray.length;
            int j = 0;
            int res = 0;
            Set<Character> set = new HashSet<>();
            for(int i=0; i<n; i++){
                if(j == n){
                    break;
                }
                if(i == j){
                    set.clear();
                    set.add(charArray[i]);
                    j++;
                }
                for(; j<n; j++){
                    if(set.contains(charArray[j])){
                        break;
                    }else{
                        set.add(charArray[j]);
                    }
                }
                res = Math.max(res, set.size());
                set.remove(charArray[i]);
            }
            return res;
        }
    }
}
