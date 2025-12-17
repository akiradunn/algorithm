package com.akiradunn.oj.leetcode.tree;
import com.akiradunn.oj.common.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 *
 *
 * 注意：本题与 783 https://leetcode.cn/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class Solution530 {

    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> res = new ArrayList<>();
        int result = Integer.MAX_VALUE;
        int i = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root);
            if(res.size() > 1) {
                result = Math.min(Math.abs(res.get(i).val - res.get(i-1).val), result);}
            root = root.right;
            i++;
        }

        return result;
    }

}
