package com.akiradunn.oj.leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//56. 合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//提示：
//
//1 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 104
//通过次数210,375提交次数468,170
public class Solution56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0) return new int[0][2];
            List<int[]> merged = new ArrayList<>();
            Arrays.sort(intervals, new Comparator<int[]>(){
                @Override
                public int compare(int[] lInterval, int[] rInterval){
                    return lInterval[0] - rInterval[0];
                }
            });
            for(int i=0; i<intervals.length; i++){
                int l = intervals[i][0];
                int r = intervals[i][1];
                if(merged.size() == 0 || merged.get(merged.size()-1)[1] < l){
                    merged.add(new int[]{l, r});
                }else {
                    int[] temp = merged.get(merged.size()-1);
                    temp[1] = Math.max(temp[1], r);
                }
            }

            return merged.toArray(new int[][]{});
        }
    }

    class Solution2 {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 1) return intervals;
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> res = new ArrayList<>();
            int[] last = new int[]{intervals[0][0], intervals[0][1]};
            for(int i=1; i<intervals.length; i++){
                int[] cur = intervals[i];
                if(cur[0] > last[1]){
                    res.add(new int[]{last[0], last[1]});
                    last[0] = cur[0];
                    last[1] = cur[1];
                    //如果到最后一个元素了
                    if(i == intervals.length-1){
                        res.add(new int[]{cur[0], cur[1]});
                    }
                }else{
                    int r = Math.max(last[1], cur[1]);
                    last[1] = r;
                    //如果到最后一个元素了
                    if(i == intervals.length-1){
                        res.add(new int[]{last[0], last[1]});
                    }
                }
            }
            return res.toArray(new int[][]{});
        }
    }
}
