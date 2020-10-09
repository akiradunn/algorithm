package com.akiradunn.oj.leetcode;

/**
 * 164-最大间距
 * @author duanzengliang
 * @since 2020/10/9 12:53
 */
public class Solution164 {
    public static void main(String[] args) {
        Solution164 test = new Solution164();
//        int[] nums = new int[]{1,3,100};
//        int[] nums = new int[]{3,6,9,1};
        int[] nums = new int[]{100,3,2,1};
        System.out.println(test.maximumGap(nums));
    }

    /**
     * 最大间距:给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于 2，则返回 0。
     *
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     *
     * 输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     *
     * 说明:
     *
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     */
    public int maximumGap(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        //分桶,比较每个桶的min和前一个桶的最大值之间的差距,取所有桶差距的最大值即为答案
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        //计算桶大小
        int bucketCount = nums.length;
        int bucketSize = (max - min) == 0 ? 0 : (max-min) % bucketCount == 0 ? (max-min) / bucketCount : (max-min) / bucketCount +1;

        if(bucketSize == 0){
            return 0;
        }

        Bucket[] buckets = new Bucket[bucketCount];
        //把数丢进桶里,并维护每个桶的最大最小
        for (int i = 0; i < bucketCount; i++) {
            //哈希计算桶的位置
            int bucketIndex = (nums[i] - min) % bucketSize == 0 ? (nums[i] - min) / bucketSize : (nums[i] - min) / bucketSize + 1;
            bucketIndex = bucketIndex == 0 ? 0 : bucketIndex -1;
            if(buckets[bucketIndex] == null){
                buckets[bucketIndex] = new Bucket();
            }
            buckets[bucketIndex].max = Math.max(nums[i],buckets[bucketIndex].max);
            buckets[bucketIndex].min = Math.min(nums[i],buckets[bucketIndex].min);
        }
        //计算桶之间的差距,找寻最大差距,最大差距即是各个桶之间的差距
        int maxGap = 0;
        //存储上一个最大值,因为有些桶可能没有装入元素,桶对象为空,至少存在一个桶
        int previousMax = buckets[0].max;
        for (int i = 0; i < buckets.length; i++) {
            if(i!=0 && buckets[i] != null){
                maxGap = Math.max(maxGap,buckets[i].min - previousMax);
                previousMax = buckets[i].max;
            }
        }
        return maxGap;
    }

    class Bucket{
        public int max;
        public int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public Bucket(){
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
    }
}
