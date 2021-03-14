package com.akiradunn.oj.leetcode.dp;
//132. 分割回文串 II
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
//返回符合要求的 最少分割次数 。
//
//
//
//示例 1：
//
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//示例 2：
//
//输入：s = "a"
//输出：0
//示例 3：
//
//输入：s = "ab"
//输出：1
//
//
//提示：
//
//1 <= s.length <= 2000
//s 仅由小写英文字母组成
//通过次数40,828提交次数83,388
public class ALISolution132 {
    class Solution {
        boolean[][] isCycle;
        public int minCut(String s) {
            if(s=="" || s.length()==0 || s.length()==1) return 0;
            int len = s.length();
            isCycle = new boolean[len][len];
            for(int j=0; j<len; j++){
                //自顶向下，避免i+1,j-1数组越界
                for(int i=j; i>=0; i--){
                    char a = s.charAt(i);
                    char b = s.charAt(j);
                    if(i == j){
                        isCycle[i][j] = true;
                    }else {
                        if(j-i+1 == 2){
                            isCycle[i][j] = a==b;
                        }else{
                            isCycle[i][j] = isCycle[i+1][j-1] && a==b;
                        }
                    }
                }
            }
            int min = len-1;
            int[] f = new int[len];
            for(int j=0; j<len; j++){
                if(isCycle[0][j]){
                    f[j]=0;
                }else{
                    //考虑分割成0至j-1、j两部分
                    f[j] = f[j-1] + 1;
                    //考虑分割为0至i-1、i至j构成回文串两部分
                    for(int i=j-1; i>=1; i--){
                        if(isCycle[i][j]){
                            f[j] = Math.min(f[j], f[i-1]+1);
                        }
                    }
                }
            }
            return f[len-1];
        }
    }
}
