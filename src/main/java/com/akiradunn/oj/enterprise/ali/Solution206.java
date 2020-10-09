package com.akiradunn.oj.enterprise.ali;

import java.util.ArrayList;
import java.util.List;

/**
 * 206.反转链表
 * @author duanzengliang
 * @since 2020/10/9 16:20
 */
public class Solution206 {


    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode head = new ListNode(1);
        solution206.reverseList(head);
    }


    public ListNode reverseList(ListNode head) {
        ListNode retNode = null;
        ListNode posNode = head;
        List<Integer> list = new ArrayList<>();
        while(posNode != null){
            list.add(posNode.val);
            posNode = posNode.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer integer = list.get(i);
            if(retNode == null){
                retNode = new ListNode(integer);
                posNode = retNode;
            }else{
                posNode.next = new ListNode(integer);
                posNode = posNode.next;
            }
        }
        return retNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 官方题解
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     */
    public ListNode reverseListByLeetCode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
