package com.akiradunn.oj.leetcode.dp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//139. 单词拆分
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//说明：
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
//示例 1：
//
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//示例 2：
//
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//示例 3：
//
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //靠死记硬背是解决不了所有问题的，如果分析问题总是f[i]与f[i-1]这样分析，永远解决不了问题，需要分析子问题的选取
        //f[i]是否可以被拆分，取决于子问题的选取（f[j] && s.substring(j, i)的结果），这里需要确定字符串长度为i时的拆分点，需要for循环找到这个点
        Set<String> set = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(f[j] && set.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}