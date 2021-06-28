package com.akiradunn.oj.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//349. 两个数组的交集
//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//示例 2：
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//说明：
//
//输出结果中的每个元素一定是唯一的。
//我们可以不考虑输出结果的顺序。
//通过次数189,667提交次数257,246
public class Solution349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> m1 = new HashSet<>();
            Set<Integer> m2 = new HashSet<>();
            for(Integer val : nums1){
                m1.add(val);
            }
            for(Integer val : nums2){
                m2.add(val);
            }
            List<Integer> res = new ArrayList<>();
            for(Integer val : m1){
                if(m2.contains(val)){
                    res.add(val);
                }
            }
            return res.stream().mapToInt(i -> i.intValue()).toArray();
        }
    }
}
