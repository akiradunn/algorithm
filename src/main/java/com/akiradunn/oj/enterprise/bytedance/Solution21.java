package com.akiradunn.oj.enterprise.bytedance;
import com.akiradunn.oj.common.ListNode;
//21. 合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
//示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//示例 2：
//
//输入：l1 = [], l2 = []
//输出：[]
//示例 3：
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//提示：
//
//两个链表的节点数目范围是 [0, 50]
//-100 <= Node.val <= 100
//l1 和 l2 均按 非递减顺序 排列
//通过次数568,994提交次数862,149
public class Solution21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode u = l1;
            ListNode d = l2;
            ListNode res = new ListNode(-5);
            ListNode head = res;
            while(u != null && d != null){
                if(u.val <= d.val){
                    head.next = new ListNode(u.val);
                    u = u.next;
                }else{
                    head.next = new ListNode(d.val);
                    d = d.next;
                }
                head = head.next;
            }

            if(u == null){
                head.next = d;
            }else{
                head.next = u;
            }

            return res.next;
        }
    }
}
