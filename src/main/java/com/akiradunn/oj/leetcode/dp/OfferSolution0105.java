package com.akiradunn.oj.leetcode.dp;
//面试题 01.05. 一次编辑
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//
//
//示例 1:
//
//输入:
//first = "pale"
//second = "ple"
//输出: True
//
//
//示例 2:
//
//输入:
//first = "pales"
//second = "pal"
//输出: False
//通过次数23,602提交次数71,153
public class OfferSolution0105 {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if(first.length() == 0) return second.length() <= 1;
            if(second.length() == 0) return first.length() <= 1;
            int m = first.length();
            int n = second.length();
            int[][] f = new int[m][n];
            char[] firstChar = first.toCharArray();
            char[] secondChar = second.toCharArray();
            f[0][0] = firstChar[0] == secondChar[0] ? 0 : 1;
            for(int i=1; i<m; i++){
                if(firstChar[i] == secondChar[0]){
                    f[i][0] = i;
                }else {
                    f[i][0] = Math.min(f[i-1][0], i) + 1;
                }
            }
            for(int j=1; j<n; j++){
                if(secondChar[j] == firstChar[0]){
                    f[0][j] = j;
                }else {
                    f[0][j] = Math.min(f[0][j-1], j) + 1;
                }
            }

            for(int i=1; i<m; i++){
                for(int j=1; j<n; j++){
                    if(firstChar[i] == secondChar[j]){
                        f[i][j] = f[i-1][j-1];
                    }else{
                        //替换、删除、插入比较
                        f[i][j] = Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1])) + 1;
                    }
                }
            }

            return f[m-1][n-1] <= 1;
        }
    }
}
