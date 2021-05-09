package com.akiradunn.oj.enterprise.bytedance;
//33. 搜索旋转排序数组
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
//给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
//示例 1：
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//示例 2：
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//示例 3：
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//提示：
//
//1 <= nums.length <= 5000
//-10^4 <= nums[i] <= 10^4
//nums 中的每个值都 独一无二
//题目数据保证 nums 在预先未知的某个下标上进行了旋转
//-10^4 <= target <= 10^4
//
//
//进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
//
//通过次数274,651提交次数659,821
public class Solution33 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int l = 0;
            int r = n-1;
            while(l <= r){
                int mid = (l + r) / 2;
                if(nums[mid] == target){
                    return mid;
                }
                //左侧有序
                if(nums[l] <= nums[mid]){
                    //在左侧区间就去左边找
                    if(nums[l] <= target && target <= nums[mid]){
                        r = mid - 1;
                    //不在左侧区间就去右边找
                    }else{
                        l = mid + 1;
                    }
                //右侧有序
                }else{
                    //在右侧区间就去右边找
                    if(nums[mid] <= target && target <= nums[r]){
                        l = mid + 1;
                    //不在右侧区间就去左边找
                    }else{
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    class Solution2 {
        public int search(int[] nums, int target) {
            for(int i=0; i<nums.length-1; i++){
                if(nums[i] == target){
                    return i;
                }else if(nums[i] > nums[i+1]){
                    return binarySearch(nums, i+1, nums.length-1, target);
                }
            }
            return nums[nums.length-1] == target ? nums.length-1 : -1;
        }

        public int binarySearch(int[] nums, int l, int r, int target){
            while(l <= r){
                int mid = (l + r) / 2;
                if(nums[mid] > target){
                    r = r - 1;
                }else if(nums[mid] < target){
                    l = l + 1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
    }
}
