package com.akiradunn.oj.leetcode.backtrack;

import java.util.HashMap;
import java.util.Map;
//回淑+dp
//464. 我能赢吗
//在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
//
//如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
//
//例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
//
//给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
//
//你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
//
//示例：
//
//输入：
//maxChoosableInteger = 10
//desiredTotal = 11
//
//输出：
//false
//
//解释：
//无论第一个玩家选择哪个整数，他都会失败。
//第一个玩家可以选择从 1 到 10 的整数。
//如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
//第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
//同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
//通过次数8,479提交次数24,215
public class Solution464 {
    class Solution {
        Map<Integer, Boolean> memo = new HashMap<>();
        public boolean canIWin(int n, int desiredTotal) {
            //等差数列求和， 如果从 1 ~ n的和小于desiredTotal 返回false
            if(n + n * (n - 1) / 2 < desiredTotal)  return false;
            return dfs(new boolean[n + 1],desiredTotal,  n);
        }

        //是否胜利
        public boolean dfs(boolean[] st, int curTotal, int n){
            int key = format(st);
            if(memo.containsKey(key))   return memo.get(key);
            //暴力枚举所有状态
            for(int i = 1; i <= n; i++){
                if(!st[i]){
                    if(curTotal - i <= 0)  return true; //能减到小于等于0， 就获胜
                    st[i] = true;
                    boolean dfs = dfs(st, curTotal - i, n);
                    if(!dfs){
                        //只要后面那个输了， 那么就必胜
                        st[i] = false;
                        memo.put(key, true);
                        return true;
                    }
                    st[i] = false;
                }
            }
            memo.put(key, false);
            return false;
        }
        //转状态为数字
        public int format(boolean[] st){
            int num = 0;
            for(int i = 0; i < st.length; i++){
                if(st[i])   num |= 1;
                num <<= 1;
            }
            return num;
        }
    }
}
