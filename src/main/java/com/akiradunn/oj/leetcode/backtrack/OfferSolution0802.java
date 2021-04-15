package com.akiradunn.oj.leetcode.backtrack;
import java.util.*;
//面试题 08.02. 迷路的机器人
//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
//
//
//
//网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
//
//示例 1:
//
//输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释:
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
//说明：r 和 c 的值均不超过 100。
//
//通过次数8,521提交次数23,939
public class OfferSolution0802 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        //备忘录剪枝
        Set<String> meno = new HashSet<>();
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1){
                return res;
            }
            List<List<Integer>> path = new ArrayList<>();
            path.add(Arrays.asList(0, 0));
            backTracking(0, 0, path, obstacleGrid);
            return res;
        }

        //回溯遍历所有子问题解
        public void backTracking(int i, int j, List<List<Integer>> path, int[][] obstacleGrid){
            if(meno.contains(genKey(i, j))){
                return;
            }

            if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1 && obstacleGrid[i][j] != 1){
                res = new ArrayList(path);
                return;
            }

            if(i < obstacleGrid.length-1 && obstacleGrid[i+1][j] != 1){
                path.add(Arrays.asList(i+1, j));
                backTracking(i+1, j, path, obstacleGrid);
                path.remove(path.size()-1);
                //只要是回溯访问过的坐标, 代表子问题已经有过解了, 无需再次求解, 记在备忘录中
                meno.add(genKey(i+1, j));
            }

            if(j < obstacleGrid[0].length-1 && obstacleGrid[i][j+1] != 1){
                path.add(Arrays.asList(i, j+1));
                backTracking(i, j+1, path, obstacleGrid);
                path.remove(path.size()-1);
                //只要是回溯访问过的坐标, 代表子问题已经有过解了, 无需再次求解, 记在备忘录中
                meno.add(genKey(i, j+1));
            }

        }

        public String genKey(int i, int j){
            return String.valueOf(i) + "-" + String.valueOf(j);
        }
    }
}
