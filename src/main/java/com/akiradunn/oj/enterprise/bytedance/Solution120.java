package com.akiradunn.oj.enterprise.bytedance;
import java.util.List;
//120. 三角形最小路径和
//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
//每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
//示例 1：
//
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//示例 2：
//
//输入：triangle = [[-10]]
//输出：-10
//
//
//提示：
//
//1 <= triangle.length <= 200
//triangle[0].length == 1
//triangle[i].length == triangle[i - 1].length + 1
//-104 <= triangle[i][j] <= 104
//
//
//进阶：
//
//你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
//通过次数149,358提交次数221,286
public class Solution120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            if(m == 0) return 0;
            int n = triangle.get(m-1).size();
            if(m == 1 && n == 1) return triangle.get(0).get(0);
            int[][] f = new int[m][n];
            f[0][0] = triangle.get(0).get(0);
            int res = Integer.MAX_VALUE;
            for(int i=1; i<m; i++){
                for(int j=0; j<=i; j++){
                    int val = triangle.get(i).get(j);
                    if(j==i){
                        f[i][j] = f[i-1][j-1] + val;
                    }else if(j==0){
                        f[i][j] = f[i-1][j] + val;
                    }else if(j>=1){
                        f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + val;
                    }
                    if(i==m-1){
                        res = Math.min(res, f[i][j]);
                    }
                }
            }
            return res;
        }
    }
}
