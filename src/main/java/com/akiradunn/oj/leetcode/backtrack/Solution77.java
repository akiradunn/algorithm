package com.akiradunn.oj.leetcode.backtrack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//77. 组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//示例:
//
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//通过次数148,856提交次数194,273
public class Solution77 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            if(n==0 || k==0) return res;
            Deque<Integer> path = new ArrayDeque<>();
            backTrack(k, n, 1, path);
            return res;
        }

        public void backTrack(int k, int n, int cur, Deque<Integer> path){
            if(path.size() == k){
                res.add(new ArrayList<>(path));
            }
            for(int i=cur; i<=n; i++){
                path.addLast(i);
                backTrack(k, n, i+1, path);
                path.removeLast();
            }
        }
    }
}
