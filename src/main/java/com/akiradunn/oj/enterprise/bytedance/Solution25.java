package com.akiradunn.oj.enterprise.bytedance;
//25. K 个一组翻转链表
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。
//
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//进阶：
//
//你可以设计一个只使用常数额外空间的算法来解决此问题吗？
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//示例 3：
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//示例 4：
//
//输入：head = [1], k = 1
//输出：[1]
//提示：
//
//列表中节点的数量在范围 sz 内
//1 <= sz <= 5000
//0 <= Node.val <= 1000
//1 <= k <= sz
//通过次数171,786提交次数264,960
public class Solution25 {

    public static void main(String[] args) {
        int[] keys = new int[]{1,2,3,4,5};
        int k = 3;
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i=1; i<=4; i++){
            temp.next = new ListNode(keys[i]);
            temp = temp.next;
        }
        Solution solution = new Solution();
        ListNode listNode = solution.reverseKGroup(head, k);
        while(listNode!=null){
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }

    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null) return null;
            ListNode hair = new ListNode(-5);
            hair.next = head;
            ListNode tail = hair;
            ListNode prev = null;
            ListNode next = null;
            while(tail != null){
                //重置指针状态
                prev = tail;
                for(int i=1; i<=k; i++){
                    tail = tail.next;
                    if(tail == null){
                        return hair.next;
                    }
                }
                next = tail.next;
                //反转链表
                ListNode[] reverse = reverse(prev.next, tail);
                //更新, 新的tail为翻转前的prev.next, 例如[1, 2],翻转前tail指向2, 翻转后为[2,1], 进行下一轮循环前tail要变为指向1
                tail = prev.next;
                //拼接
                prev.next = reverse[0];
                reverse[1].next = next;
            }
            return hair.next;
        }

        public ListNode[] reverse(ListNode head, ListNode tail){
            ListNode prev = tail.next;
            ListNode cur = head;
            while(prev != tail){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return new ListNode[]{tail, head};
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
