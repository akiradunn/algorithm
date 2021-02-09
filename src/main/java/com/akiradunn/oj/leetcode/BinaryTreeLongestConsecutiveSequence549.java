package com.akiradunn.oj.leetcode;
public class BinaryTreeLongestConsecutiveSequence549 {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return max;
        }

        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int inc = 1;
        int dec = 1;
        if(root.left != null){
            int[] l = dfs(root.left);
            if(root.left.val + 1 == root.val){
                dec = l[0] + 1;
            }
            if(root.left.val - 1 == root.val){
                inc = l[1] + 1;
            }
        }
        if(root.right != null){
            int[] r = dfs(root.right);
            if(root.right.val + 1 == root.val){
                dec = Math.max(dec, r[0] + 1);
            }
            if(root.right.val - 1 == root.val){
                inc = Math.max(inc, r[1] + 1);
            }
        }
        max = Math.max(max, dec + inc -1);
        return new int[]{dec, inc};
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}