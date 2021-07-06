package com.akiradunn.oj.leetcode.array;

import java.util.*;
//219. 存在重复元素 II
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
//
//
//
//示例 1:
//
//输入: nums = [1,2,3,1], k = 3
//输出: true
//示例 2:
//
//输入: nums = [1,0,1,1], k = 1
//输出: true
//示例 3:
//
//输入: nums = [1,2,3,1,2,3], k = 2
//输出: false
//通过次数98,037提交次数231,643
public class Solution219 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1,1,22,3,4,5,6,5,3};
        solution.containsNearbyDuplicate(array, 1);
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; ++i) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }

    //错误
    class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, List<Integer>> meno = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                if(meno.containsKey(nums[i])){
                    List<Integer> t = meno.get(nums[i]);
                    t.add(i);
                    meno.put(nums[i], t);
                }else{
                    meno.put(nums[i], new ArrayList<>(Arrays.asList(i)));
                }
            }

            for(Integer val : meno.keySet()){
                List<Integer> t = meno.get(val);
                if(t.size() <= 1){
                    continue;
                }
                for(int i=0; i<t.size()-1; i++){
                    for(int j=i+1; j<t.size(); j++){
                        if(Math.abs(i-j) <= k){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
