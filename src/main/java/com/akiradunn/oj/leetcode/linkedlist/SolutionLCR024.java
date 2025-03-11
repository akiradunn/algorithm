package com.akiradunn.oj.leetcode.linkedlist;

import com.akiradunn.oj.common.ListNode;

/**
 * LCR 024. 反转链表
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 *
 *
 * 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class SolutionLCR024 {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            // 只需处理当前节点的 next 指针为 pre, 无需考虑 next 指针的 next 信息要怎么修改, 迭代之后自然能处理到
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
