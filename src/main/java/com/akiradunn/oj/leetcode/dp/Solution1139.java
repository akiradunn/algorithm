package com.akiradunn.oj.leetcode.dp;
//1139. 最大的以 1 为边界的正方形
//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
//
//
//
//示例 1：
//
//输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
//示例 2：
//
//输入：grid = [[1,1,0,0]]
//输出：1
//
//
//提示：
//
//1 <= grid.length <= 100
//1 <= grid[0].length <= 100
//grid[i][j] 为 0 或 1
//通过次数8,059提交次数17,268
public class Solution1139 {
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    int bound = (m-i) < (n-j) ? (m-i) : (n-j);
                    for(int k=1; k<=bound; k++){
                        int r = 0;
                        int d = 0;
                        int rd = 0;
                        int dr = 0;
                        //右
                        int it = i;
                        int jt = j;
                        //把grid[it][jt]==1, 写错成grid[it][jt]=='1'..., 严谨...
                        while(jt <= j+k-1 && grid[it][jt]==1){
                            r++;
                            jt++;
                        }
                        //下
                        jt = j;
                        while(it <= i+k-1 && grid[it][jt]==1){
                            d++;
                            it++;
                        }
                        //右下
                        it = i;
                        jt = j+k-1;
                        while(it <= i+k-1 && grid[it][jt]==1){
                            rd++;
                            it++;
                        }
                        //下右
                        jt = j;
                        it = i+k-1;
                        while(jt <= j+k-1 && grid[it][jt]==1){
                            dr++;
                            jt++;
                        }
                        if(r+d+rd+dr == 4*k){
                            res = Math.max(res, k);
                        }
                    }
                }
            }
            return res*res;
        }
    }
}
