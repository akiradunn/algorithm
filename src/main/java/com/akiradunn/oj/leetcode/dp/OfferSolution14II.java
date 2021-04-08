package com.akiradunn.oj.leetcode.dp;
import java.math.BigInteger;
import java.util.Arrays;
//剑指 Offer 14- II. 剪绳子 II
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
//示例 1：
//
//输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1
//示例 2:
//
//输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//
//
//提示：
//
//2 <= n <= 1000
//注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
//
//通过次数54,836提交次数179,674
public class OfferSolution14II {
    class Solution {
        public int cuttingRope(int n) {
            BigInteger[] f = new BigInteger[n+1];
            Arrays.fill(f, BigInteger.valueOf(1));
            for(int i=3; i<=n; i++){
                for(int j=2; j<i; j++){
                    f[i] = f[i].max(BigInteger.valueOf(j * (i - j))).max((f[j].multiply(BigInteger.valueOf((i-j)))));
                }
            }
            return f[n].mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }
}
