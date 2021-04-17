package com.akiradunn.oj.leetcode.dp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//面试题 17.08. 马戏团人塔
//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
//
//示例：
//
//输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
//提示：
//
//height.length == weight.length <= 10000
//通过次数6,609提交次数24,749
public class OfferSolution1708 {
    //自行实现贪心+二分
    class Solution1 {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            if(height.length == 0) return 0;
            int n = height.length;
            List<Node> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new Node(height[i], weight[i]));
            }

            Node[] listNode = list.toArray(new Node[]{});
            //此处容易忽略, 身高相同但体重不同的人不可以被同时选中两个
            Arrays.sort(listNode, (o1, o2) -> {
                return o1.h == o2.h ? o2.w - o1.w : o1.h - o2.h;
            });

            //求最长递增子序列
            //以输入序列 [0, 8, 4, 12, 2]为例：
            //
            //第一步插入 0，d = [0]；
            //
            //第二步插入 8，d = [0, 8]；
            //
            //第三步插入 4，d = [0, 4]；
            //
            //第四步插入 12，d = [0, 4, 12]；
            //
            //第五步插入 2，d = [0, 2, 12]。
            int[] f = new int[n];
            int len = 1;
            f[0] = listNode[0].w;
            for(int i=1; i<n; i++){
                if(listNode[i].w > f[len-1]){
                    f[len++] = listNode[i].w;
                }else{
                    //找到找满足 f[i - 1] < listNode[i].w < f[i]的下标，并更新f[i] = listNode[i].w
                    int l = 0;
                    int r = len-1;
                    while(l <= r){
                        int mid = (l + r) >> 1;
                        if(f[mid] < listNode[i].w){
                            l = mid + 1;
                        }else{
                            r = mid - 1;
                        }
                    }
                    f[r+1] = listNode[i].w;
                }
            }
            return len;
        }

        class Node{
            public int h;
            public int w;
            public Node(int h, int w){
                this.h = h;
                this.w = w;
            }
        }
    }

    //dp超时
    class Solution2 {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            if(height.length == 0) return 0;
            int n = height.length;
            List<Node> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new Node(height[i], weight[i]));
            }

            Node[] listNode = list.toArray(new Node[]{});
            //此处容易忽略, 身高相同但体重不同的人不可以被同时选中两个
            Arrays.sort(listNode, (o1, o2) -> {
                return o1.h == o2.h ? o2.w - o1.w : o1.h - o2.h;
            });
            //求最长递增子序列
            int[] f = new int[n];
            int res = 1;
            for(int i=0; i<n; i++){
                f[i] = 1;
                for(int j=0; j<i; j++){
                    if(listNode[j].w < listNode[i].w){
                        f[i] = Math.max(f[i], f[j]+1);
                    }
                }
                res = Math.max(res, f[i]);
            }
            return res;
        }

        class Node{
            public int h;
            public int w;
            public Node(int h, int w){
                this.h = h;
                this.w = w;
            }
        }
    }

    class Solution3 {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            if(height.length == 0) return 0;
            int n = height.length;
            List<Node> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new Node(height[i], weight[i]));
            }

            Node[] listNode = list.toArray(new Node[]{});
            //此处容易忽略, 身高相同但体重不同的人不可以被同时选中两个
            Arrays.sort(listNode, (o1, o2) -> {
                return o1.h == o2.h ? o2.w - o1.w : o1.h - o2.h;
            });
            //求最长递增子序列
            int[] f = new int[n];
            int res = 0;
            for(int i=0; i<n; i++){
                //这里的二分查找可以不超时
                int index = Arrays.binarySearch(f, 0, res, listNode[i].w);
                if (index < 0)
                    index = -(index + 1);
                f[index] = listNode[i].w;
                if (index == res)
                    ++res;
            }
            return res;
        }

        class Node{
            public int h;
            public int w;
            public Node(int h, int w){
                this.h = h;
                this.w = w;
            }
        }
    }
}
