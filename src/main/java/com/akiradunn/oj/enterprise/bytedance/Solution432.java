package com.akiradunn.oj.enterprise.bytedance;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//432. 全 O(1) 的数据结构
//请你实现一个数据结构支持以下操作：
//
//Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
//Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
//GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
//GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
//
//
//挑战：
//
//你能够以 O(1) 的时间复杂度实现所有操作吗？
//
//通过次数5,677提交次数15,281
public class Solution432 {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        allOne.getMinKey();
        allOne.dec("a");
        allOne.getMaxKey();
        allOne.getMinKey();
    }

    static class AllOne {
        Map<String, ListNode> map;
        DoubleLinkedList dll;

        /** Initialize your data structure here. */
        public AllOne() {
            this.map = new HashMap<>();
            this.dll = new DoubleLinkedList();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if(!map.containsKey(key)){
                if(dll.head.next.val == 1){
                    dll.head.next.set.add(key);
                    map.put(key, dll.head.next);
                }else{
                    ListNode newNode = new ListNode(1);
                    newNode.set.add(key);
                    dll.addBack(dll.head, newNode);
                    map.put(key, newNode);
                }
            }else{
                ListNode node = map.get(key);
                int val = node.val;
                int newVal = val + 1;
                if(newVal != node.next.val){
                    ListNode newNode = new ListNode(newVal);
                    newNode.set.add(key);
                    dll.addBack(node, newNode);
                    map.put(key, newNode);
                }else{
                    node.next.set.add(key);
                    map.put(key, node.next);
                }
                node.set.remove(key);
                if(node.set.size() == 0){
                    dll.delete(node);
                }
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if(!map.containsKey(key)){
                return;
            }

            ListNode node = map.get(key);
            int val = node.val;
            if(val == 1){
                //val==1不可以直接dll.delete节点, 因为还有其他节点存在
                node.set.remove(key);
                map.remove(key);
                if(node.set.size() == 0){
                    dll.delete(node);
                }
                return;
            }
            int newVal = val - 1;
            if(newVal != node.prev.val){
                ListNode newNode = new ListNode(newVal);
                newNode.set.add(key);
                dll.addFront(node, newNode);
                map.put(key, newNode);
            }else{
                node.prev.set.add(key);
                map.put(key, node.prev);
            }

            node.set.remove(key);
            if(node.set.size() == 0){
                dll.delete(node);
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return dll.head.next == dll.tail ? "" : dll.tail.prev.set.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return dll.head.next == dll.tail ? "" : dll.head.next.set.iterator().next();
        }

        class DoubleLinkedList{
            ListNode head, tail;
            public DoubleLinkedList(){
                this.head = new ListNode(-5);
                this.tail = new ListNode(-5);
                head.next = tail;
                tail.prev = head;
            }

            public void delete(ListNode node){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            public void addFront(ListNode cur, ListNode node){
                node.prev = cur.prev;
                node.next = cur;

                cur.prev.next = node;
                cur.prev = node;
            }

            public void addBack(ListNode cur, ListNode node){
                node.prev = cur;
                node.next = cur.next;

                cur.next.prev = node;
                cur.next = node;
            }
        }

        class ListNode{
            int val;
            ListNode prev;
            ListNode next;
            Set<String> set;
            public ListNode(int val){
                this.val = val;
                this.set = new HashSet<>();
            }
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
