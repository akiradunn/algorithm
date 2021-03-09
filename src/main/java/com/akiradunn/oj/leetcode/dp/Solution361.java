package com.akiradunn.oj.leetcode.dp;
//361. 轰炸敌人
//想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
//
//'W' 表示一堵墙
//'E' 表示一个敌人
//'0'（数字 0）表示一个空位
//
//
//请你计算一个炸弹最多能炸多少敌人。
//
//由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。
//
//注意：你只能把炸弹放在一个空的格子里
//
//示例:
//
//输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//输出: 3
//解释: 对于如下网格
//
//0 E 0 0
//E 0 W E
//0 E 0 0
//
//假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
//通过次数2,338提交次数4,303
public class Solution361 {
    class Solution {
        public int maxKilledEnemies(char[][] grid) {
            if(grid.length == 0 || grid[0].length == 0) return 0;
            int m = grid.length;
            int n = grid[0].length;
            int max = 0;
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    int value = 0;
                    if(grid[i-1][j-1] != '0'){
                        continue;
                    }
                    int x = j;
                    int y = i;
                    //上
                    for(;y>=1;y--){
                        if(grid[y-1][x-1] == 'W'){
                            break;
                        }else if(grid[y-1][x-1] == '0'){
                            continue;
                        }else {
                            value++;
                        }
                    }

                    x = j;
                    y = i;
                    //下
                    for(;y<=m;y++){
                        if(grid[y-1][x-1] == 'W'){
                            break;
                        }else if(grid[y-1][x-1] == '0'){
                            continue;
                        }else {
                            value++;
                        }
                    }

                    x = j;
                    y = i;
                    //左
                    for(;x>=1;x--){
                        if(grid[y-1][x-1] == 'W'){
                            break;
                        }else if(grid[y-1][x-1] == '0'){
                            continue;
                        }else {
                            value++;
                        }
                    }

                    x = j;
                    y = i;
                    //右
                    for(;x<=n;x++){
                        if(grid[y-1][x-1] == 'W'){
                            break;
                        }else if(grid[y-1][x-1] == '0'){
                            continue;
                        }else {
                            value++;
                        }
                    }
                    max = Math.max(max, value);
                }
            }
            return max;
        }
    }
}
