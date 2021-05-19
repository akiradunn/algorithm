package com.akiradunn.oj.enterprise.bytedance;
import com.akiradunn.oj.common.ListNode;
//2. 两数相加
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
//示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//示例 2：
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//示例 3：
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//提示：
//
//每个链表中的节点数在范围 [1, 100] 内
//0 <= Node.val <= 9
//题目数据保证列表表示的数字不含前导零
//通过次数839,874提交次数2,090,741
public class Solution2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode head = res;
            int prev = 0;
            while(l1 != null && l2 != null){
                int sum = l1.val + l2.val + prev;
                prev = sum / 10;
                int remain = sum % 10;
                head.next = new ListNode(remain);
                head = head.next;
                if(l1.next == null && l2.next == null){
                    if(prev != 0){
                        head.next = new ListNode(prev);
                    }
                    return res.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }

            if(l1 == null){
                head.next = l2;
            }else if(l2 == null){
                head.next = l1;
            }

            head = head.next;
            while(prev != 0 && head != null){
                int sum = head.val + prev;
                prev = sum / 10;
                int remain = sum % 10;
                head.val = remain;
                if(prev != 0 && head.next == null){
                    head.next = new ListNode(prev);
                    break;
                }
                head = head.next;
            }

            return res.next;
        }
    }
}
