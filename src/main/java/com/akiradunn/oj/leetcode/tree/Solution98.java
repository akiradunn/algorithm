package com.akiradunn.oj.leetcode.tree;
/**
 98. 验证二叉搜索树
 已解答
 中等
 相关标签
 premium lock icon
 相关企业
 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

 有效 二叉搜索树定义如下：

 节点的左子树只包含 严格小于 当前节点的数。
 节点的右子树只包含 严格大于 当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。


 示例 1：


 输入：root = [2,1,3]
 输出：true
 示例 2：


 输入：root = [5,1,4,null,null,3,6]
 输出：false
 解释：根节点的值是 5 ，但是右子节点的值是 4 。


 提示：

 树中节点数目范围在[1, 104] 内
 -231 <= Node.val <= 231 - 1
 */
import com.akiradunn.oj.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root).getLegal();
    }

    /**
     * 不仅要比较当前树根节点与左节点、右节点, 还要比较左、右子树的 min、max 是否符合条件
     */
    public SubTreeInfo checkValidBST(TreeNode root) {
        if (root == null) {
            return new SubTreeInfo(true);
        }
        int a = root.val;
        if (root.left != null) {
            int b = root.left.val;
            if (b >= a)
                return new SubTreeInfo(false);
        }
        if (root.right != null) {
            int c = root.right.val;
            if (c <= a)
                return new SubTreeInfo(false);
        }

        SubTreeInfo leftSubTreeInfo = checkValidBST(root.left);
        SubTreeInfo rightSubTreeInfo = checkValidBST(root.right);
        if (!leftSubTreeInfo.getLegal() || !rightSubTreeInfo.getLegal()) {
            return new SubTreeInfo(false);
        }

        Integer leftMax = leftSubTreeInfo.getMax();
        Integer rightMin = rightSubTreeInfo.getMin();
        if ((leftMax != null && leftMax >= root.val) || (rightMin != null && rightMin <= root.val)) {
            return new SubTreeInfo(false);
        }

        Integer leftMin = leftSubTreeInfo.getMin();
        Integer rightMax = rightSubTreeInfo.getMax();

        int max;
        if (leftMax != null && rightMax != null) {
            max = Math.max(root.val, Math.max(leftMax, rightMax));
        } else if (leftMax != null) {
            max = Math.max(root.val, leftMax);
        } else if (rightMax != null) {
            max = Math.max(root.val, rightMax);
        } else {
            max = root.val;
        }

        int min;
        if (leftMin != null && rightMin != null) {
            min = Math.min(root.val, Math.min(leftMin, rightMin));
        } else if (leftMin != null) {
            min = Math.min(root.val, leftMin);
        } else if (rightMin != null) {
            min = Math.min(root.val, rightMin);
        } else {
            min = root.val;
        }
        return new SubTreeInfo(true, max, min);
    }

    private static class SubTreeInfo{
        private boolean legal;
        private Integer max;
        private Integer min;

        public SubTreeInfo(boolean legal, Integer max, Integer min) {
            this.legal = legal;
            this.max = max;
            this.min = min;
        }

        public SubTreeInfo(boolean legal) {
            this.legal = legal;
        }

        public Integer getMax(){
            return max;
        }

        public Integer getMin() {
            return min;
        }

        public Boolean getLegal() {
            return legal;
        }
    }
}