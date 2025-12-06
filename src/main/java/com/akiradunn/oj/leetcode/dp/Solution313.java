package com.akiradunn.oj.leetcode.dp;
import java.util.HashSet;
import java.util.Set;
/**
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 *
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *
 * 提示：
 *
 * 1 <= n <= 105
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 *
 *
 * 1。 有了思路不要立刻去写代码，不要太急于求成了
 * 要仔细想下思路是否正确， 是否有一些问题， 是否有更好的方案
 * 如果可行再去执行写代码
 * 2。 不要想到一个点， 觉得可行， 就马上写代码
 * 结果发现思路是错的，白白浪费了时间和机会
 * 3。用代入法代替 debug
 * 4。遇到了问题不要盲目尝试， 要思考问题本质， 再行动
 */
public class Solution313 {

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(5911, new int[]{2,3,5,7}));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        // 不定义为 Long, 会溢出
        Long[] dp = new Long[n+1];
        dp[1] = 1L;
        int[] pointer = new int[primes.length];
        for (int i=0; i<primes.length; i++) {
            pointer[i] = 1;
        }

        Set<Long> meno = new HashSet<>();
        for (int i=2; i<=n; i++) {
            int minIndex = -1;
            long min = Long.MAX_VALUE;
            for (int j=0; j<primes.length; j++) {
                // 之前已经在结果集里的元素, 需要跳过, 直到没有存在的元素出现, 才继续下一步
                while (meno.contains(dp[pointer[j]] * primes[j])) {
                    pointer[j] = pointer[j] + 1;
                }
                long cur = dp[pointer[j]] * primes[j];
                if (cur <= min) {
                    min = cur;
                    minIndex = j;
                }
            }
            dp[i] = min;
            meno.add(min);
            pointer[minIndex] = pointer[minIndex] + 1;
        }
        return dp[n].intValue();
    }
}
