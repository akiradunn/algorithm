package com.akiradunn.oj.leetcode.linkedlist;

import com.akiradunn.oj.common.ListNode;

//24. 两两交换链表中的节点
//中等
//相关标签
//相关企业
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//示例 2：
//
//输入：head = []
//输出：[]
//示例 3：
//
//输入：head = [1]
//输出：[1]
//
//
//提示：
//
//链表中节点的数目在范围 [0, 100] 内
//0 <= Node.val <= 100
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (newHead == null) {
                newHead = cur.next;
            }
            cur.next = next.next;
            next.next = cur;
            // 除了两个节点要进行交换，还要把交换后的两个节点与前面的节点进行关联
            if (prev != null) {
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
        }

        return newHead;
    }

}
