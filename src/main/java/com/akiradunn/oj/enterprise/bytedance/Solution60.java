package com.akiradunn.oj.enterprise.bytedance;

import java.util.HashMap;
import java.util.Map;

//60. 排列序列
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
//按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//给定 n 和 k，返回第 k 个排列。
//
//
//
//示例 1：
//
//输入：n = 3, k = 3
//输出："213"
//示例 2：
//
//输入：n = 4, k = 9
//输出："2314"
//示例 3：
//
//输入：n = 3, k = 1
//输出："123"
//
//
//提示：
//
//1 <= n <= 9
//1 <= k <= n!
//通过次数79,968提交次数153,479
public class Solution60 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 3);
        System.out.println(permutation);
    }

    static class Solution {
        public String getPermutation(int n, int k) {
            Map<Integer, Integer> meno = new HashMap<>();
            int[] last = new int[n];
            last[0] = 1;
            for(int i=0; i<=n; i++){
                last[i] = last[i-1] * i;
            }
            StringBuilder builder = new StringBuilder();
            boolean[] visited = new boolean[9];
            for(int i=1; i<=n; i++){
                int cur = k / last[n-i];
                k = k % last[n-i];
                int t = 0;
                //判断是否可用, 找到最大可用的数
                for(int j=1; j<=9; j++){
                    if(!visited[j-1]){
                        if(++t == cur){
                            cur = j;
                            break;
                        }
                    }
                }
                visited[cur-1] = true;
                builder.append(cur);
            }
            return builder.toString();
        }
    }
}
