package com.akiradunn.oj.leetcode.doublePointer;

/**
 * 125. 验证回文串
 * 简单
 * 相关标签
 * 相关企业
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 *
 * <a href="https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l<=s.length()-1 && ilLegal(s.charAt(l))) {
                l++;
            }
            while (r>=0 && ilLegal(s.charAt(r))) {
                r--;
            }

            if (l >= r) {
                break;
            }

            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);
            if (leftChar <= 'Z' && leftChar >= 'A') {
                leftChar = (char) (leftChar + 32);
            }
            if (rightChar <= 'Z' && rightChar >= 'A') {
                rightChar = (char) (rightChar + 32);
            }

            if (leftChar != rightChar) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean ilLegal(char character) {
        if (character <= 'Z' && character >= 'A') {
            return false;
        }
        if (character <= 'z' && character >= 'a') {
            return false;
        }
        if (character <= '9' && character >= '0') {
            return false;
        }
        return true;
    }

}
