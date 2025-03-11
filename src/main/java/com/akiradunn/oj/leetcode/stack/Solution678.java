package com.akiradunn.oj.leetcode.stack;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 678. 有效的括号字符串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是有效字符串返回 true 。
 *
 * 有效字符串符合如下规则：
 *
 * 任何左括号 '(' 必须有相应的右括号 ')'。
 * 任何右括号 ')' 必须有相应的左括号 '(' 。
 * 左括号 '(' 必须在对应的右括号之前 ')'。
 * '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "(*)"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(*))"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s[i] 为 '('、')' 或 '*'
 *
 * <a href="https://leetcode.cn/problems/valid-parenthesis-string/description/">...</a>
 */
public class Solution678 {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> starStack = new LinkedList<Integer>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }
}
