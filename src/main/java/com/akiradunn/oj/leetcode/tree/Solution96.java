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
     * 暴露问题: 想的点都很零碎, 没有串连起来
     * 1. 第一要务，不是思考套什么方法，而是看懂题目，找规律，题目的示例是怎么程序得出来的
     * 2. 方法入参、出参、边界条件、结束条件
     * 3. 主函数调用逻辑是怎样的
     * 4。题目给到的条件，一定要利用起来，能降低时间复杂度
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

    public static int numTreesV2(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[n] = f(1) + f(2) + f(3) + ... f(n)
        // f(n) 代表 n 为顶点的二叉搜索树的总数
        for (int i=1; i<=n; i++) {
            int sum = 0;
            // i 当顶点的时候, 讨论左子树总节点树的情况
            for (int j=1; j<=i; j++) {
                // 从左子树为0个节点, 到左子树有 i-1 个节点, 右子树节点数从 i-1 递减为 0
                // 左子树不能有 i 个节点, 因为 i 已经拿来当顶点了
                sum = sum + dp[j-1] * dp[i-j];
            }
            dp[i] = sum;
        }

        return dp[n];
    }
}