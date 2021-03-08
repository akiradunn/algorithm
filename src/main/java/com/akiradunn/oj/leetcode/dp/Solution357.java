package com.akiradunn.oj.leetcode.dp;
//357. 计算各个位数不同的数字个数
//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
//
//示例:
//
//输入: 2
//输出: 91
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
//通过次数19,064提交次数36,949
public class Solution357 {
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if(n == 0) return 1;
            if(n == 1) return 10;
            //n超过10位时, 必有重复数字
            int size = Math.min(n, 10);
            //f[i]代表, 位数为i时, 不同的数字个数, 依据排列组合来确定
            int[] f = new int[size + 1];
            f[1] = 10;
            f[2] = 9 * 9;
            int res = f[1] + f[2];
            for(int i=3; i<=size; i++){
                f[i] = f[i-1] * (10-i+1);
                res = res + f[i];
            }
            return res;
        }
    }
}
