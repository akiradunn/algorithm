package com.akiradunn.oj.enterprise.ali;
/**
 * 4-寻找两个正序数组的中位数
 * @author duanzengliang
 * @since 2020/10/9 22:38
 */
public class Solution4 {

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     */

    public static void main(String[] args) {
        Solution4 findSolution = new Solution4();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = findSolution.findMedianSortedArrays(nums1, nums2);
        System.out.println("结果是："+medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int oneRight = nums1.length-1;
        int twoRight = nums2.length-1;
        //是偶数,查找索引为totalLen/2 和 totalLen/2 -1大的数
        if(totalLen % 2 == 0){
            double first = 0;
            double second = 0;
            int seq = 0;
            for(; seq <= totalLen/2;seq ++){
                int record = 0;
                if(oneRight>=0 && (twoRight <0 || nums1[oneRight] >= nums2[twoRight])){
                    record = nums1[oneRight];
                    oneRight --;
                }else if(twoRight>=0 && (oneRight <0 || nums1[oneRight] <= nums2[twoRight])){
                    record = nums2[twoRight];
                    twoRight --;
                }
                if(seq == totalLen/2 -1){
                    first = record;
                }
                if(seq == totalLen/2){
                    second = record;
                }
            }
            return (first+second)/2;
        }
        //是奇数,查找索引为第totalLen/2的数
        else{
            int seq = 0;
            double ret = 0d;
            for(; seq <= totalLen/2;seq ++){
                int record = 0;
                if(oneRight>=0 && (twoRight < 0 || nums1[oneRight] >= nums2[twoRight])){
                    record = nums1[oneRight];
                    oneRight --;
                }else if(twoRight>=0 && (oneRight < 0 || nums1[oneRight] <= nums2[twoRight])){
                    record = nums2[twoRight];
                    twoRight --;
                }
                if(seq == totalLen/2){
                    ret = record;
                }
            }
            return ret;
        }
    }
}
