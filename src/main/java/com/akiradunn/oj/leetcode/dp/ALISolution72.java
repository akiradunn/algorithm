package com.akiradunn.oj.leetcode.dp;
//72. 编辑距离
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符
//
//
//示例 1：
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//示例 2：
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//提示：
//
//0 <= word1.length, word2.length <= 500
//word1 和 word2 由小写英文字母组成
//通过次数113,269提交次数187,019
public class ALISolution72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            if((word1 == null || word1 == "") && (word2 == null || word2 == "")) return 0;
            int m = word1.length();
            int n = word2.length();
            int[][] f = new int[m+1][n+1];
            //初始化
            for(int j=1; j<=n; j++){
                f[0][j] = f[0][j-1] + 1;
            }
            for(int i=1; i<=m; i++){
                f[i][0] = f[i-1][0] + 1;
            }
            //求解
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        f[i][j] = f[i-1][j-1];
                    }else{
                        f[i][j] = Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1])) + 1;
                    }
                }
            }
            return f[m][n];
        }
    }
}
