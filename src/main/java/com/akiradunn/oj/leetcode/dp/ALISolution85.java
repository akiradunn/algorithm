package com.akiradunn.oj.leetcode.dp;
//85. 最大矩形
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//
//
//示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
//示例 2：
//
//输入：matrix = []
//输出：0
//示例 3：
//
//输入：matrix = [["0"]]
//输出：0
//示例 4：
//
//输入：matrix = [["1"]]
//输出：1
//示例 5：
//
//输入：matrix = [["0","0"]]
//输出：0
//
//
//提示：
//
//rows == matrix.length
//cols == matrix[0].length
//0 <= row, cols <= 200
//matrix[i][j] 为 '0' 或 '1'
//通过次数70,848提交次数137,103
public class ALISolution85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] f = new int[m][n];
            //初始化节点连续1的个数
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(j == 0){
                        f[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    }else {
                        f[i][j] = matrix[i][j] == '1' ? f[i][j-1] + 1 : 0;
                    }
                }
            }
            //最大面积初始化为0而非Integer.MIN_VALUE
            int maxSum = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    int u = i;
                    int wide = Integer.MAX_VALUE;
                    while(u >= 0 && matrix[u][j] == '1'){
                        //此处需要找到最小的宽
                        wide = Math.min(wide, f[u][j]);
                        int t = wide * (i-u+1);
                        maxSum = Math.max(maxSum, t);
                        u--;
                    }
                }
            }
            return maxSum;
        }
    }
}
