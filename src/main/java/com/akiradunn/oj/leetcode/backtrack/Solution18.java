package com.akiradunn.oj.leetcode.backtrack;
import java.util.*;
//18. 四数之和
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//注意：答案中不可以包含重复的四元组。
//
//
//
//示例 1：
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//示例 2：
//
//输入：nums = [], target = 0
//输出：[]
//
//
//提示：
//
//0 <= nums.length <= 200
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//通过次数173,776提交次数432,267
public class Solution18 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Solution2 solution = new Solution2();

        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        long start = System.currentTimeMillis();
        List<List<Integer>> lists = solution.fourSum(nums, target);
        long end = System.currentTimeMillis() - start;
        System.out.println("耗时：" + end);
        System.out.println("结果：" + lists.toString());
    }

    //排序+双指针, 将暴力枚举n的4次方, 改为n的3次方, 枚举前两个数, 后两个数通过双指针选择, 减少一层for循环
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums.length == 0) return res;
            int n = nums.length;
            Arrays.sort(nums);
            for(int i=0; i<n-3; i++){
                if(i>0 && nums[i] == nums[i-1]){
                    break;
                }
                if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                    break;
                }
                if(nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target){
                    continue;
                }
                for(int j=i+1; j<n-2; j++){
                    if(j>i+1 && nums[j] == nums[j-1]){
                        continue;
                    }

                    if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                        break;
                    }
                    if(nums[i] + nums[j] + nums[n-2] + nums[n-1] < target){
                        continue;
                    }
                    int l = j+1;
                    int r = n-1;
                    while(l < r){
                        if(nums[l] == nums[l+1]){
                            l++;
                            continue;
                        }
                        if(nums[r] == nums[r-1]){
                            r--;
                            continue;
                        }
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if(sum > target){
                            r--;
                        }else if(sum < target){
                            l--;
                        }else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while(l < r && nums[l] == nums[l+1]){
                                l++;
                            }
                            l++;
                            while(l < r && nums[r] == nums[r-1]){
                                r--;
                            }
                            r--;
                        }
                    }
                }
            }
            return res;
        }
    }

    //回溯法超时...
    static class Solution2 {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, List<Integer>> meno = new HashMap<>();
        Set<String> set = new HashSet<>();

        public List<List<Integer>> fourSum(int[] nums, int target) {
            if(nums.length == 0) return res;
            int n = nums.length;
            boolean[] visisted = new boolean[n];
            Deque<Integer> path = new ArrayDeque<>();
            backTracing(nums, visisted, path, 0, target);
            for(String key : meno.keySet()){
                List<Integer> tempRecord = meno.get(key);
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[tempRecord.get(0)]);
                temp.add(nums[tempRecord.get(1)]);
                temp.add(nums[tempRecord.get(2)]);
                temp.add(nums[tempRecord.get(3)]);
                String resKey = getResKey(temp, nums);
                if(set.contains(resKey)){
                    continue;
                }
                set.add(resKey);
                res.add(temp);
            }
            return res;
        }

        public void backTracing(int[] nums, boolean[] visisted, Deque<Integer> path, int totalSum, int target){
            if(path.size() > 4){
                return;
            }

            if(path.size() == 4 && totalSum == target){
                String key = genKey(path);
                if(meno.containsKey(key)){
                    return;
                }
                meno.put(key, new ArrayList<>(path));
                return;
            }

            for(int i=0; i<nums.length; i++){
                if(!visisted[i] && path.size() <= 3){
                    visisted[i] = true;
                    path.offerFirst(i);
                    backTracing(nums, visisted, path, totalSum+nums[i], target);
                    path.removeFirst();
                    visisted[i] = false;
                }
            }
        }

        public String genKey(Deque<Integer> path){
            List<Integer> temp1 = new ArrayList<>(path);
            Integer[] temp = temp1.toArray(new Integer[]{});
            Arrays.sort(temp);
            String key = temp[0] + "-" + temp[1] + "-" + temp[2] + "-" + temp[3];
            return key;
        }

        public String getResKey(List<Integer> temp, int[] nums){
            Integer[] arr = temp.toArray(new Integer[]{});
            Arrays.sort(arr);
            return arr[0] + "!" + arr[1] + "!" + arr[2] + "!" + arr[3];
        }
    }

}
