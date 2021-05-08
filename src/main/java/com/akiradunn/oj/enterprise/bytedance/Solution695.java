package com.akiradunn.oj.enterprise.bytedance;
//695. 岛屿的最大面积
//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
//一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//
//找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
//
//
//
//示例 1:
//
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
//
//示例 2:
//
//[[0,0,0,0,0,0,0,0]]
//对于上面这个给定的矩阵, 返回 0。
//
//
//
//注意: 给定的矩阵grid 的长度和宽度都不超过 50。
//
//通过次数88,766提交次数136,134
public class Solution695 {
    class Solution {
        int m;
        int n;
        public int maxAreaOfIsland(int[][] grid) {
            m= grid.length;
            n= grid[0].length;
            if(m == 0) return 0;
            int res = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] == 0){
                        continue;
                    }
                    boolean[][] visited = new boolean[m][n];
                    res = Math.max(res, dfs(grid, visited, i, j));
                }
            }
            return res;
        }

        public int dfs(int[][] grid, boolean[][] visited, int i, int j){
            if(grid[i][j] == 0 || visited[i][j]){
                return 0;
            }
            int u = 0;
            int d = 0;
            int l = 0;
            int r = 0;
            visited[i][j] = true;
            if(i>0 && grid[i-1][j] == 1){
                u = dfs(grid, visited, i-1, j);
            }
            if(j<n-1 && grid[i][j+1] == 1){
                d = dfs(grid, visited, i, j+1);
            }
            if(j>0 && grid[i][j-1] == 1){
                l = dfs(grid, visited, i, j-1);
            }
            if(i<m-1 && grid[i+1][j] == 1){
                r = dfs(grid, visited, i+1, j);
            }
            return u + d + l + r + 1;
        }
    }
}
