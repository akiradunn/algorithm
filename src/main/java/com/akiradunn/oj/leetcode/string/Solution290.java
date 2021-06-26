package com.akiradunn.oj.leetcode.string;

import java.util.HashMap;
import java.util.Map;

//290. 单词规律
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
//这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
//示例1:
//
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
//示例 2:
//
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
//示例 3:
//
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
//示例 4:
//
//输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
//说明:
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
//
//通过次数74,188提交次数162,159
public class Solution290 {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] split = s.split(" ");
            char[] charArray = pattern.toCharArray();
            if(split.length != charArray.length) return false;
            Map<Character, String> map = new HashMap<>();
            Map<String, Character> reverseMap = new HashMap<>();
            for(int i=0; i<split.length; i++){
                if(reverseMap.containsKey(split[i]) && !(charArray[i] == reverseMap.get(split[i]))){
                    return false;
                }
                if(map.containsKey(charArray[i])){
                    if(!split[i].equals(map.get(charArray[i]))){
                        return false;
                    }
                }else{
                    map.put(charArray[i], split[i]);
                    reverseMap.put(split[i], charArray[i]);
                }
            }
            return true;
        }
    }
}
