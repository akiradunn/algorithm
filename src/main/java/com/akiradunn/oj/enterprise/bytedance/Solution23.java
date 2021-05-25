package com.akiradunn.oj.enterprise.bytedance;

import com.akiradunn.oj.common.ListNode;

//23. 合并K个升序链表
//给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
//示例 1：
//
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//示例 2：
//
//输入：lists = []
//输出：[]
//示例 3：
//
//输入：lists = [[]]
//输出：[]
//
//
//提示：
//
//k == lists.length
//0 <= k <= 10^4
//0 <= lists[i].length <= 500
//-10^4 <= lists[i][j] <= 10^4
//lists[i] 按 升序 排列
//lists[i].length 的总和不超过 10^4
//通过次数261,508提交次数474,188
public class Solution23 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKLists(lists, 0, lists.length-1);
        }

        public ListNode mergeKLists(ListNode[] lists, int l, int r){
            if(l > r){
                return null;
            }else if(l == r){
                return lists[l];
            }

            int mid = (l + r) / 2;
            ListNode left = mergeKLists(lists, l, mid);
            ListNode right = mergeKLists(lists, mid+1, r);

            return merge(left, right);
        }

        public ListNode merge(ListNode l1, ListNode l2) {
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
