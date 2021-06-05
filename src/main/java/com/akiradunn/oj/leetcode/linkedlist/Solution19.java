package com.akiradunn.oj.leetcode.linkedlist;
import com.akiradunn.oj.common.ListNode;
//19. 删除链表的倒数第 N 个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//进阶：你能尝试使用一趟扫描实现吗？
//
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//示例 2：
//
//输入：head = [1], n = 1
//输出：[]
//示例 3：
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//提示：
//
//链表中结点的数目为 sz
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz
//通过次数403,497提交次数961,269
public class Solution19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null) return null;
            ListNode node = new ListNode(-5);
            node.next = head;
            ListNode fast = node.next;
            ListNode slow = node.next;
            int span = 0;
            while(fast != null && span < n){
                fast = fast.next;
                span++;
            }
            if(fast == null && span < n){
                return null;
            }
            ListNode prev = node;
            while(fast != null){
                fast = fast.next;
                prev = slow;
                slow = slow.next;
            }
            //删除
            prev.next = slow.next;
            return node.next;
        }
    }
}
