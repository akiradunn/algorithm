package com.akiradunn.oj.enterprise.bytedance;
import com.akiradunn.oj.common.ListNode;
//148. 排序链表
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//进阶：
//
//你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//示例 3：
//
//输入：head = []
//输出：[]
//
//
//提示：
//
//链表中节点的数目在范围 [0, 5 * 104] 内
//-105 <= Node.val <= 105
//通过次数169,063提交次数252,576
public class Solution148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail){
            if(head == null){
                return head;
            }

            if(head.next == tail){
                head.next = null;
                return head;
            }

            ListNode fast = head;
            ListNode slow = head;

            //快2步, 慢1步找到中点
            while(fast != tail){
                slow = slow.next;
                fast = fast.next;
                if(fast != tail){
                    fast = fast.next;
                }
            }

            ListNode mid = slow;

            ListNode l1 = sortList(head, mid);
            ListNode l2 = sortList(mid, tail);
            ListNode res = merge(l1, l2);

            return res;
        }

        public ListNode merge(ListNode l1, ListNode l2){
            if(l1 == null){
                return l2;
            }else if(l2 == null){
                return l1;
            }

            ListNode head = new ListNode();
            ListNode cur = head, temp1 = l1, temp2 = l2;
            while(temp1 != null && temp2 != null){
                if(temp1.val <= temp2.val){
                    cur.next = temp1;
                    temp1 = temp1.next;
                }else{
                    cur.next = temp2;
                    temp2 = temp2.next;
                }
                cur = cur.next;
            }

            if(temp1 == null){
                cur.next = temp2;
            }else if(temp2 == null){
                cur.next = temp1;
            }

            return head.next;
        }
    }
}
