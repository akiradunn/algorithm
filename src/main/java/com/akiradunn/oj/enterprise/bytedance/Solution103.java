package com.akiradunn.oj.enterprise.bytedance;
import com.akiradunn.oj.common.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//103. 二叉树的锯齿形层序遍历
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回锯齿形层序遍历如下：
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//通过次数141,236提交次数247,309
public class Solution103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            boolean reverse = false;
            while(!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                int levelSize = queue.size();
                if(reverse){

                    for(int i=levelSize; i>=1; i--){
                        TreeNode node = queue.removeLast();
                        if(node.right != null){
                            queue.addFirst(node.right);
                        }
                        if(node.left != null){
                            queue.addFirst(node.left);
                        }
                        list.add(node.val);
                    }

                }else{

                    for(int i=1; i<=levelSize; i++){
                        TreeNode node = queue.removeFirst();
                        if(node.left != null){
                            queue.addLast(node.left);
                        }
                        if(node.right != null){
                            queue.addLast(node.right);
                        }
                        list.add(node.val);
                    }

                }

                res.add(list);
                reverse = !reverse;

            }
            return res;
        }
    }
}
