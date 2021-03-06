package com.akiradunn.oj.enterprise.bytedance;
import java.util.Arrays;
import java.util.Comparator;
//354. 俄罗斯套娃信封问题
//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
//当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//
//请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
//注意：不允许旋转信封。
//
//
//示例 1：
//
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
//示例 2：
//
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
//
//
//提示：
//
//1 <= envelopes.length <= 5000
//envelopes[i].length == 2
//1 <= wi, hi <= 104
//通过次数58,864提交次数133,347
public class Solution354 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            if(n==0) return 0;
            Arrays.sort(envelopes, new Comparator<int[]>(){
                public int compare(int[] cp1, int[] cp2){
                    return cp1[0] - cp2[0];
                }
            });
            int[] f = new int[n];
            int res = 0;
            for(int i=0; i<n; i++){
                f[i] = 1;
                for(int j=0; j<i; j++){
                    if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                        f[i] = Math.max(f[i], f[j]+1);
                    }
                }
                res = Math.max(res, f[i]);
            }
            return res;
        }
    }
}
