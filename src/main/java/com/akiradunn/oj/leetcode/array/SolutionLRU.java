package com.akiradunn.oj.leetcode.array;

import java.util.*;

/**
 * 面试题 16.25. LRU 缓存
 *
 * <a href="https://leetcode.cn/problems/lru-cache-lcci/description/">...</a>
 */
public class SolutionLRU {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
    }

    static class LRUCache {

        private CacheList queue;
        private Map<Integer, CacheItem> cache;
        private int capacity;
        private int curSize;

        /**
         * 链表节点的变化，都要考虑节点的 prev、next 指针要指向哪里
         */
        public LRUCache(int capacity) {
            this.queue =  new CacheList();
            this.cache = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {

            CacheItem node = cache.get(key);

            if (node != null) {
                // 删除链表中的节点，再把它移动到队尾
                // 一个链表节点被删除，是它的前一个节点的 next 指针，后一个节点的 prev 指针变动
                node.prev.next = node.next;
                node.next.prev = node.prev;
                queue.moveToTail(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (get(key) != -1) {
                cache.get(key).value = value;
                return;
            }
            CacheItem node = new CacheItem(key, value);
            cache.put(key, node);
            queue.moveToTail(node);

            if (cache.size() > capacity) {
                cache.remove(queue.head.next.key);
                queue.head.next = queue.head.next.next;
                queue.head.next.prev = queue.head;
            }
        }
    }

    static class CacheItem {
        public CacheItem prev;
        public CacheItem next;
        public Integer key;
        public Integer value;

        public CacheItem(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static class CacheList {
        public CacheItem head;
        public CacheItem tail;

        public CacheList() {
            // 两个假节点，不管如何操作链表，head、tail 都是链表中初始化时的头尾节点，保持不变；增加、删除都是在 head、tail 之间修改删除
            this.head = new CacheItem(-1, -1);
            this.tail = new CacheItem(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void addLast(CacheItem node) {
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            node.next = tail;
        }

        public void moveToTail(CacheItem node) {
            tail.prev.next = node;
            node.prev =  tail.prev;
            tail.prev = node;
            node.next  = tail;
        }
    }




    /**
     * 超时版
     */
//    class LRUCache {
//
//        private Deque<String> cache;
//        private int capacity;
//        private int curSize;
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            this.cache =  new LinkedList<>();
//            this.curSize = 0;
//        }
//
//        public int get(int key) {
//            Iterator<String> iterator = cache.iterator();
//            while (iterator.hasNext()) {
//                String entry = (String) iterator.next();
//                String[] array = entry.split("-");
//                if (Integer.parseInt(array[0]) == key) {
//                    iterator.remove();
//                    cache.addLast(entry);
//                    return Integer.parseInt(array[1]);
//                }
//            }
//
//            return -1;
//        }
//
//        public void put(int key, int value) {
//            Iterator<String> iterator = cache.iterator();
//            while (iterator.hasNext()) {
//                String entry = iterator.next();
//                String[] array = entry.split("-");
//                if (Integer.parseInt(array[0]) == key) {
//                    iterator.remove();
//                    curSize --;
//                    break;
//                }
//            }
//
//            cache.addLast(key + "-" + value);
//            curSize ++;
//
//            if (curSize > capacity) {
//                cache.pollFirst();
//                curSize --;
//            }
//        }
//    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
