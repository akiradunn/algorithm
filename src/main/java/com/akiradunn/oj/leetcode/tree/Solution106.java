package com.akiradunn.oj.leetcode.tree;

import com.akiradunn.oj.common.TreeNode;

//106. 从中序与后序遍历序列构造二叉树
//已解答
//中等
//相关标签
//相关企业
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
//
//
//
//示例 1:
//
//
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
//示例 2:
//
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
//
//
//提示:
//
//1 <= inorder.length <= 3000
//postorder.length == inorder.length
//-3000 <= inorder[i], postorder[i] <= 3000
//inorder 和 postorder 都由 不同 的值组成
//postorder 中每一个值都在 inorder 中
//inorder 保证是树的中序遍历
//postorder 保证是树的后序遍历
public class Solution106 {


    private static int postIndex;

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = 0;
        int r = postorder.length - 1;
        postIndex = r;
        return buildTree(inorder, postorder, l, r);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, int l, int r) {
        if (l > r) {
            return null;
        }

        // 后序遍历输出结果顺序是，左孩子、右孩子、根节点，所以理解数组就应该是 len-1 根节点，len-2 右孩子，len-3 左孩子
        TreeNode root = new TreeNode(postorder[postIndex]);
        // 每次递归都要占用一个后序遍历输出
        postIndex --;
        for (int i=0; i<inorder.length; i++) {
            // 减一之后要加上才能知道之前的那个被比较的元素
            if (inorder[i] == postorder[postIndex + 1]) {
                root.right = buildTree(inorder, postorder, i + 1, r);
                root.left = buildTree(inorder, postorder, l, i - 1);
                break;
            }
        }

        return root;
    }
}
