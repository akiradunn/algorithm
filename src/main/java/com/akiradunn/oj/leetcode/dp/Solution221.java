package com.akiradunn.oj.leetcode.dp;
//221. 最大正方形
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
//示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//输出：4
//示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//示例 3：
//
//输入：matrix = [["0"]]
//输出：0
//
//
//提示：
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 300
//matrix[i][j] 为 '0' 或 '1'
public class Solution221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            //f[i][j]代表以i,j为右下角的区域里面找到的最大边长;
            int[][] f = new int[matrix.length][matrix[0].length];
            int maxSide = 0;
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    if(matrix[i][j] == '0'){
                        f[i][j] = 0;
                        continue;
                    }
                    if(i==0 || j==0){
                        f[i][j] = 1;
                    }else{
                        //具体数学证明,注意此处子问题解有三个,而非经典的两个;
                        //dp仍需要具体拆分子问题解
                        f[i][j] = Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1])) + 1;
                    }
                    maxSide = Math.max(maxSide, f[i][j]);
                }
            }
            return maxSide * maxSide;
        }
    }
}
