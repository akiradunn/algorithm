package com.akiradunn.oj.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= n <= 19
 */
class Solution96 {

    /**
     * 暴露问题: 想的点都很零碎, 都没有串连起来
     */
    public int numTrees(int n) {
        List<Integer> selectiveNumbers = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            selectiveNumbers.add(i);
        }
        return dfs(selectiveNumbers, new HashMap<>());
    }

    public int dfs(List<Integer> selectiveNumbers, Map<String, Integer> meno) {
        if (selectiveNumbers.size() == 0) {
            return 1;
        }

        int result = 0;
        // 确定当前节点是谁
        for (int i=0; i<selectiveNumbers.size(); i++) {
            int num = selectiveNumbers.get(i);
            List<Integer> less = new ArrayList<>();
            List<Integer> more = new ArrayList<>();

            for (int k : selectiveNumbers) {
                if (k < num) {
                    less.add(k);
                }
                if (k > num) {
                    more.add(k);
                }
            }

            // 比当前节点小的当作左子树, 同时用备忘录降低递归次数
            String lessMenoKey = less.toString();
            int left = meno.containsKey(lessMenoKey) ? meno.get(lessMenoKey) : dfs(less, meno);
            meno.putIfAbsent(lessMenoKey, left);

            // 比当前节点大的当作右子树, 同时用备忘录降低递归次数
            String moreMenoKey = more.toString();
            int right = meno.containsKey(moreMenoKey) ? meno.get(moreMenoKey) : dfs(more, meno);
            meno.putIfAbsent(moreMenoKey, right);

            // 当当前节点确定时, 当前树的种类树 = 左子树种类数 * 右子树种类树
            result = result + left * right;
        }

        return result;
    }
}