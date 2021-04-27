package com.akiradunn.oj.leetcode.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//
//
//示例 1：
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//示例 2：
//
//输入：nums = []
//输出：[]
//示例 3：
//
//输入：nums = [0]
//输出：[]
//
//
//提示：
//
//0 <= nums.length <= 3000
//-105 <= nums[i] <= 105
//通过次数457,893提交次数1,455,685
public class ALISolution15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if(nums.length < 3) return res;
            Arrays.sort(nums);
            for(int i=0; i<nums.length; i++){
                if(nums[i] > 0) break;
                //重复数字跳过
                if(i>0 && nums[i] == nums[i-1]) continue;
                int target = -nums[i];
                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[left] + nums[right] == target){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        //采用双指针法优化查找效率, a+b+c=0, a固定, b变大, 则c会变小, b变大c变小符合双指针移动趋势
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }else if(nums[left] + nums[right] > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
            return res;
        }
    }

    //双指针法
    class Solution2 {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums.length == 0) return res;
            int n = nums.length;
            Arrays.sort(nums);
            for(int i=0; i<n-2; i++){
                if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                if(nums[i] + nums[i+1] + nums[i+2] > 0){
                    continue;
                }
                int l = i+1;
                int r = n-1;
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0){
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                        while(l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        l++;
                        while(l < r && nums[r] == nums[r-1]){
                            r--;
                        }
                        r--;
                    }else if(sum > 0){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
            return res;
        }
    }
}
