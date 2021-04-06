package com.akiradunn.oj.leetcode.dp;
import java.util.Arrays;
//673. 最长递增子序列的个数
//给定一个未排序的整数数组，找到最长递增子序列的个数。
//
//示例 1:
//
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//示例 2:
//
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
//
//通过次数19,881提交次数52,707
public class Solution673 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            if(nums.length == 1) return 1;
            int n = nums.length;
            int[] f = new int[n+1];
            f[1] = 1;
            int[] count = new int[n+1];
            Arrays.fill(count, 1);
            Arrays.fill(f, 1);
            int maxIncreaseSubsequence = 0;
            for(int i=2; i<=n; i++){
                for(int j=0; j<i-1; j++){
                    //此处不能为<=,因为递增子序列是不包含相等的元素的
                    if(nums[j] < nums[i-1]){
                        if(f[i] < f[j+1]+1){
                            f[i] = f[j+1] + 1;
                            count[i] = count[j+1];
                        }else if(f[i] == f[j+1]+1){
                            count[i] = count[i] + count[j+1];
                        }
                    }
                }
                maxIncreaseSubsequence = Math.max(maxIncreaseSubsequence, f[i]);
            }

            int res = 0;
            for(int i=1; i<=n; i++){
                if(f[i] == maxIncreaseSubsequence){
                    res += count[i];
                }
            }
            return res;
        }
    }
}
