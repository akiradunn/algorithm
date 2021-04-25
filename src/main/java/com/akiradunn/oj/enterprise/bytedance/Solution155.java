package com.akiradunn.oj.enterprise.bytedance;
import java.util.ArrayDeque;
import java.util.Deque;
//155. 最小栈
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。
//
//
//示例:
//
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//提示：
//
//pop、top 和 getMin 操作总是在 非空栈 上调用。
//通过次数230,489提交次数407,133
public class Solution155 {
    class MinStack {
        private Deque<Integer> stack = new ArrayDeque<>();
        private Deque<Integer> minStack = new ArrayDeque<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            stack.addLast(val);
            if(minStack.size() == 0){
                minStack.addLast(val);
            }else{
                int lastMin = minStack.peekLast();
                minStack.addLast(val < lastMin ? val : lastMin);
            }
        }

        public void pop() {
            if(stack.size() == 0){
                return;
            }
            stack.removeLast();
            minStack.removeLast();
        }

        public int top() {
            return stack.peekLast();
        }

        public int getMin() {
            return minStack.peekLast();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
