package com.akiradunn.oj.leetcode.dp;
//剑指 Offer 63. 股票的最大利润
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
//
//
//
//示例 1:
//
//输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//示例 2:
//
//输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//限制：
//
//0 <= 数组长度 <= 10^5
//
//
//
//注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
//
//通过次数82,253提交次数129,636
public class OfferSolution63 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length < 2) return 0;
            int n = prices.length;
            int[] f = new int[n];
            f[0] = 0;
            f[1] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
            int res = f[1] > f[0] ? f[1] : f[0];
            for(int i=2; i<n; i++){
                for(int j=0; j<i; j++){
                    if(prices[j] < prices[i]){
                        f[i] = Math.max(f[i], prices[i]-prices[j]);
                    }
                }
                res = Math.max(res, f[i]);
            }
            return res;
        }
    }
}
