package com.akiradunn.oj.leetcode.tree;

import com.akiradunn.oj.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> selectiveNumbers = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            selectiveNumbers.add(i);
        }
        return dfs(selectiveNumbers);
    }

    public List<TreeNode> dfs(List<Integer> selectiveNumbers) {
        if (selectiveNumbers.size() == 0) {
            return new ArrayList<>();
        }

        List<TreeNode> result = new ArrayList<>();
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
            List<TreeNode> leftTrees = dfs(less);

            // 比当前节点大的当作右子树, 同时用备忘录降低递归次数
            List<TreeNode> rightTrees = dfs(more);

            // 当当前节点确定时, 当前树的种类树 = 左子树种类数 * 右子树种类树
            if (leftTrees.size() == 0 && rightTrees.size() == 0) {
                result.add(new TreeNode(num));
            } else if (leftTrees.size() == 0) {
                rightTrees.forEach(rightTree -> {
                    TreeNode root = new TreeNode(num);
                    root.right = rightTree;
                    result.add(root);
                });
            } else if (rightTrees.size() == 0) {
                leftTrees.forEach(leftTree -> {
                    TreeNode root = new TreeNode(num);
                    root.left = leftTree;
                    result.add(root);
                });
            } else {
                leftTrees.forEach(leftTree -> {
                    rightTrees.forEach(rightTree -> {
                        TreeNode root = new TreeNode(num);
                        root.right = rightTree;
                        root.left = leftTree;
                        result.add(root);
                    });
                });
            }
        }

        return result;
    }
}
