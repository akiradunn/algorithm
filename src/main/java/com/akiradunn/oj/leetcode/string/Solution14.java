package com.akiradunn.oj.leetcode.string;

/**
 * 14. 最长公共前缀
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuffer buffer = new StringBuffer();
        for (int i=0;;i++) {
            if (i >= strs[0].length()) {
                break;
            }
            char charAt = strs[0].charAt(i);
            for (int j = 1; j<strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != charAt) {
                    return buffer.toString();
                }
            }
            buffer.append(charAt);
        }

        return buffer.toString();
    }
}
