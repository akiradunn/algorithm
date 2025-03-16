package com.akiradunn.oj.leetcode.tree;

import com.akiradunn.oj.common.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//662. 二叉树最大宽度
//已解答
//中等
//相关标签
//相关企业
//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
//
//树的 最大宽度 是所有层中最大的 宽度 。
//
//每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
//
//题目数据保证答案将会在  32 位 带符号整数范围内。
//
//
//
//示例 1：
//
//
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
//示例 2：
//
//
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
//示例 3：
//
//
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
//
//
//提示：
//
//树中节点的数目范围是 [1, 3000]
//-100 <= Node.val <= 100
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> curLayer = new ArrayDeque<>();
        curLayer.add(new Pair<>(root, 0));

        int max = Integer.MIN_VALUE;
        while (!curLayer.isEmpty()) {
            List<Pair<TreeNode, Integer>> cur = new ArrayList<>(curLayer);

            for (Pair<TreeNode, Integer> treeNodeIntegerPair : cur) {
                curLayer.remove();

                // 左孩子与父亲的编号关系 2 * k + 1
                if (treeNodeIntegerPair.getKey().left != null) {
                    curLayer.add(new Pair<>(treeNodeIntegerPair.getKey().left, treeNodeIntegerPair.getValue() * 2 + 1));
                }
                // 右孩子与父亲的编号关系 2 * k + 2
                if (treeNodeIntegerPair.getKey().right != null) {
                    curLayer.add(new Pair<>(treeNodeIntegerPair.getKey().right, treeNodeIntegerPair.getValue() * 2 + 2));
                }
            }

            max = Math.max(max, cur.get(cur.size() - 1).getValue() - cur.get(0).getValue());
        }

        // 宽度为每层最大编号差 + 1
        return max + 1;
    }
}
