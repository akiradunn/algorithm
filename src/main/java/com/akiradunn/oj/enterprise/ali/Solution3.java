package com.akiradunn.oj.enterprise.ali;

import java.util.HashMap;
import java.util.Map;

/**
 * 3-无重复字符的最长子串
 * @author duanzengliang
 * @since 2020/10/9 12:50
 */
public class Solution3 {
    public static void main(String[] args) {
//        String test = "bbbbbb";
//        String test="au";
//        String test = "abcabcbb";
        String test = "tmmzuxt";
        Solution3 maven = new Solution3();
        System.out.println(maven.lengthOfLongestSubstring(test));

    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }

        Map<Character,Integer> charIndexMap = new HashMap<>();
        int maxSubStrLen = 0;
        //i表示子串的最左端索引
        int i = 0;
        //tail表示子串的最右端索引指针
        for (int tail=0 ; tail<s.length() ; tail++){
            //不仅要包含,而且要在子串范围内,子串之前的索引,不考虑
            if(charIndexMap.containsKey(s.charAt(tail)) && charIndexMap.get(s.charAt(tail)) >= i){
                //i仅用于计算长度使用,当出现重复字符的时候,子串长度不包含tail指向的重复字符长度
                maxSubStrLen = maxSubStrLen < tail-i ? tail-i : maxSubStrLen;
                //出现重复字符,子串的最左端索引值=重复字符在字串中第一次出现的索引位的下一位
                i = charIndexMap.get(s.charAt(tail)) + 1;
                //更新重复字符的索引位为tail
                charIndexMap.put(s.charAt(tail),tail);
            }else{
                //当没有出现重复字符的时候,子串长度包含tail指向的字符长度
                maxSubStrLen = maxSubStrLen < tail-i+1 ? tail-i+1 : maxSubStrLen;
                charIndexMap.put(s.charAt(tail),tail);
            }
        }
        return maxSubStrLen;
    }
}
