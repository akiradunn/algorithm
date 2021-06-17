package com.akiradunn.oj.leetcode.string;
import java.util.HashMap;
import java.util.Map;
//205. 同构字符串
//给定两个字符串 s 和 t，判断它们是否是同构的。
//
//如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
//每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
//示例 1:
//
//输入：s = "egg", t = "add"
//输出：true
//示例 2：
//
//输入：s = "foo", t = "bar"
//输出：false
//示例 3：
//
//输入：s = "paper", t = "title"
//输出：true
//
//
//提示：
//
//可以假设 s 和 t 长度相同。
//通过次数101,391提交次数202,636
public class Solution205 {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
    }

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            char[] charArray1 = s.toCharArray();
            char[] charArray2 = t.toCharArray();
            int m = charArray1.length;
            int n = charArray2.length;
            if(m != n) return false;
            Map<Character, Character> map = new HashMap<>();
            for(int i=0; i<m; i++){
                if(map.containsKey(charArray1[i])){
                    if(charArray2[i] != map.get(charArray1[i])){
                        return false;
                    }
                }else{
                    if(map.values().contains(charArray2[i])){
                        return false;
                    }
                    map.put(charArray1[i], charArray2[i]);
                }
            }
            return true;
        }
    }
}
