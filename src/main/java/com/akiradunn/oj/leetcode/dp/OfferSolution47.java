package com.akiradunn.oj.leetcode.dp;
//剑指 Offer 47. 礼物的最大价值
//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
//
//
//示例 1:
//
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//
//
//提示：
//
//0 < grid.length <= 200
//0 < grid[0].length <= 200
//通过次数75,590提交次数110,124
public class OfferSolution47 {
    class Solution {
        public int maxValue(int[][] grid) {
            if(grid.length==0) return 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] f = new int[m][n];
            f[0][0] = grid[0][0];
            for(int i=1; i<m; i++){
                f[i][0] = f[i-1][0] + grid[i][0];
            }
            for(int j=1; j<n; j++){
                f[0][j] = f[0][j-1] + grid[0][j];
            }

            for(int i=1; i<m; i++){
                for(int j=1; j<n; j++){
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]) + grid[i][j];
                }
            }

            return f[m-1][n-1];
        }
    }
}
