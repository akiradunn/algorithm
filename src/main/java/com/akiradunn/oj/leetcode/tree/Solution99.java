package com.akiradunn.oj.leetcode.tree;

import com.akiradunn.oj.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 *
 *
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 *
 * 提示：
 *
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 *
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 *
 *
 * 难解决的问题，考虑转换为数学问题求解
 * 出的题不会很难，要往基础知识上靠
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<TreeNode> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root);
            root = root.right;
        }

        boolean one = true;
        Integer x = null;
        Integer y = null;
        for (int i=0; i<res.size()-1; i++) {
            TreeNode cur = res.get(i);
            TreeNode next = res.get(i+1);
            if (cur.val > next.val) {
                if (x == null) {
                    x = i;
                } else {
                    y = i;
                }
            }
        }

        if (y == null) {
            swap(res.get(x), res.get(x+1));
        } else{
            swap(res.get(x), res.get(y+1));
        }
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
