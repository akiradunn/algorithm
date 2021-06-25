package com.akiradunn.oj.leetcode.array;
//258. 各位相加
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
//
//示例:
//
//输入: 38
//输出: 2
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
//进阶:
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
//
//通过次数71,816提交次数104,111
public class Solution258 {
    class Solution {
        public int addDigits(int num) {
            int res = num;
            while(res >= 10){
                int t = res;
                res = 0;
                while(t >= 10 ){
                    res += t % 10;
                    t = t / 10;
                }
                res += t;
            }
            return res;
        }
    }
}
