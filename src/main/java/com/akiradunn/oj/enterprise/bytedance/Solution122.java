package com.akiradunn.oj.enterprise.bytedance;
//122. 买卖股票的最佳时机 II
//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
//示例 1:
//
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//示例 2:
//
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//示例 3:
//
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//提示：
//
//1 <= prices.length <= 3 * 104
//0 <= prices[i] <= 104
//通过次数372,456提交次数549,826
public class Solution122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            //f[i][0]代表第i天手上没股票时的最大利润; f[i][1]代表第i天手上有股票时的最大利润;
            int[][] f = new int[n][2];
            f[0][0] = 0;
            f[0][1] = -prices[0];
            int maxProfit = 0;
            for(int i=1; i<n; i++){
                f[i][0] = Math.max(f[i-1][0], f[i-1][1]+prices[i]);
                f[i][1] = Math.max(f[i-1][1], f[i-1][0]-prices[i]);
                maxProfit = Math.max(f[i][0], f[i][1]);
            }
            return maxProfit;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if(n == 0) return 0;
            int maxProfit = 0;
            //贪心, 由于不限制交易次数, 所以只要今天股价比昨天高, 就进行交易
            for(int i=1; i<n; i++){
                int dif = prices[i] - prices[i-1];
                if(dif > 0){
                    maxProfit += dif;
                }
            }
            return maxProfit;
        }
    }
}
