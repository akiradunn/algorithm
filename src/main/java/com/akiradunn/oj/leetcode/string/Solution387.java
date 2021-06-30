package com.akiradunn.oj.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//387. 字符串中的第一个唯一字符
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
//示例：
//
//s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//提示：你可以假定该字符串只包含小写字母。
public class Solution387 {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> frequency = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < s.length(); ++i) {
                if (frequency.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        public int firstUniqChar(String s) {
            char[] charArray = s.toCharArray();
            Set<Character> meno = new HashSet<>();
            for(int i=0; i<charArray.length; i++){
                if(meno.contains(charArray[i])){
                    continue;
                }
                boolean flag = true;
                for(int j=i+1; j<charArray.length; j++){
                    if(charArray[i] == charArray[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return i;
                }
                meno.add(charArray[i]);
            }
            return -1;
        }
    }
}
