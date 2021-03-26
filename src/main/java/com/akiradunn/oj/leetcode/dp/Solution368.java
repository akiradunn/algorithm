package com.akiradunn.oj.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//368. 最大整除子集
//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
//
//如果有多个目标子集，返回其中任何一个均可。
//
//
//
//示例 1:
//
//输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
//示例 2:
//
//输入: [1,2,4,8]
//输出: [1,2,4,8]
//通过次数12,764提交次数31,815
public class Solution368 {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if(nums.length == 0) return res;
            Arrays.sort(nums);
            List[] f = new List[nums.length];
            f[0] = new ArrayList();
            f[0].add(nums[0]);
            res = f[0];
            for(int i=1; i<nums.length; i++){
                //就算没有找到这样一个元素，默认选自己
                f[i] = new ArrayList<>();
                f[i].add(nums[i]);
                for(int j=0; j<i; j++){
                    if(nums[i] % nums[j] == 0 && f[i].size() < f[j].size()+1){
                        f[i] = new ArrayList<>(f[j]);
                        f[i].add(nums[i]);
                    }
                }
                res = res.size() < f[i].size() ? f[i] : res;
            }
            return res;
        }
    }
}