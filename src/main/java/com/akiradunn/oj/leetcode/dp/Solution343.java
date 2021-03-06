package com.akiradunn.oj.leetcode.dp;
//343. 整数拆分
//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
//示例 1:
//
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//示例 2:
//
//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//说明: 你可以假设 n 不小于 2 且不大于 58。
//
//通过次数75,988提交次数127,983
public class Solution343 {
    class Solution {
        public int integerBreak(int n) {
            int f[] = new int[n+1];
            f[1] = 0;
            f[2] = 1;
            for(int i=3; i<=n; i++){
                f[i] = Integer.MIN_VALUE;
                for(int j=1; j<i; j++){
                    //这里容易漏掉的一种情况是，不拆分时可能会最大{j * (i-j)}
                    f[i] = Math.max(f[i], Math.max(f[j]*(i-j), j * (i-j)));
                }
            }
            return f[n];
        }
    }
}
