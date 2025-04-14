package com.akiradunn.oj.common.heap;
/**
 * 最小堆排序实现
 * 小顶堆，树根节点左、右子树的所有元素都要小或等于，
 * 由于此特性，只有大于根节点的元素可以入堆，可用于取出数据中的最大 top 元素列表，解决 top K 问题
 */
public class SimpleMinPQ {
    private int size;

    int[] heap = new int[size];


    // 创建一个容量为 capacity 的优先级队列
    public SimpleMinPQ(int capacity) {
        this.size = capacity;
    }

    // 返回队列中的元素个数
    public int size() {
        return size;
    }

    // 向队列中插入一个元素
    public void push(int x) {
        heap[size] = x;

        swim(size);

        // size ++ 必须放到最后面
        size ++;

    }

    // 返回队列中的最小元素（堆顶元素）
    public int peek() {
        return heap[0];
    }

    // 删除并返回队列中的最小元素（堆顶元素）
    public int pop() {
        int result = heap[0];
        size--;

        sink(0);
        return result;
    }

    public void swap(int i, int j) {
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }

    /**
     * 将指定索引 节点上浮到合适位置
     * @param index
     */
    public void swim(int index) {
        while (index != 0) {
            int parent = parent(index);
            if (heap[parent] <= heap[index]) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    /**
     * 把指定索引位置节点下沉到合适位置
     * @param index
     */
    public void sink(int index) {
        while (index < size && (left(index) < size || right(index) < size)) {
            int minIndex = index;
            if (left(index) < size && heap[minIndex] > heap[left(index)]) {
                minIndex = left(index);
            }
            if (right(index) < size && heap[minIndex] > heap[right(index)]) {
                minIndex = right(index);
            }

            if (minIndex == index) {
                break;
            }

            swap(index, minIndex);
            index = minIndex;
        }
    }
}
