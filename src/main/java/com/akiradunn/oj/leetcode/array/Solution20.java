package com.akiradunn.oj.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//
//
//示例 1：
//
//输入：s = "()"
//输出：true
//示例 2：
//
//输入：s = "()[]{}"
//输出：true
//示例 3：
//
//输入：s = "(]"
//输出：false
//示例 4：
//
//输入：s = "([)]"
//输出：false
//示例 5：
//
//输入：s = "{[]}"
//输出：true
//
//
//提示：
//
//1 <= s.length <= 104
//s 仅由括号 '()[]{}' 组成
//通过次数654,920提交次数1,483,288
public class Solution20 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("]"));
    }

    static class Solution {
        public boolean isValid(String s) {
            char[] charArray = s.toCharArray();
            if(charArray.length == 0) return true;
            Deque<Character> stack = new ArrayDeque<Character>();
            for(int i=0; i<charArray.length; i++){
                if(charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{'){
                    stack.addFirst(charArray[i]);
                }else if(stack.isEmpty()){
                    return false;
                }else if(charArray[i] == ')' && stack.peek() == '('){
                    stack.removeFirst();
                }else if(charArray[i] == ']' && stack.peek() == '['){
                    stack.removeFirst();
                }else if(charArray[i] == '}' && stack.peek() == '{'){
                    stack.removeFirst();
                }else{
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
