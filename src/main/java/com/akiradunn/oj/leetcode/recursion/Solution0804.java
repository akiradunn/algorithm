package com.akiradunn.oj.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 面试题 08.04. 幂集
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * <a href="https://leetcode.cn/problems/power-set-lcci/description/">...</a>
 */
public class Solution0804 {
    public List<List<Integer>> subsets(int[] nums) {
        Set<String> meno = new HashSet<>();
        return subsets(nums, nums.length-1, meno);
    }

    /**
     * 数组为 n 的幂集 = n-1 的幂集 + 当前元素本身组合成的子集 + n-1 的幂集各个子集与当前元素的组合而成的子集
     * @param nums
     * @param curIndex
     * @param meno
     * @return
     */
    public List<List<Integer>> subsets(int[] nums, int curIndex, Set<String> meno) {
        List<List<Integer>> result = new ArrayList<>();

        // 自己
        List<Integer> curArray = new ArrayList();
        curArray.add(nums[curIndex]);
        String curKey = genKey(curArray);

        if (!meno.contains(curKey)) {
            meno.add(curKey);
            result.add(curArray);
        }

        // 边界情况
        if (curIndex == 0) {
            result.add(new ArrayList());
            return result;
        }

        // 子集
        List<List<Integer>> sub = subsets(nums, curIndex - 1, meno);

        result.addAll(sub);

        // 需要增加的 = 子集 + 当前元素与子集各个元素组合而成的结果集
        for (int i=0; i<sub.size(); i++) {
            List<Integer> item = sub.get(i);
            List<Integer> itemCopy = new ArrayList();
            for (int j=0; j<item.size(); j++) {
                itemCopy.add(item.get(j));
            }
            itemCopy.add(nums[curIndex]);

            String key = genKey(itemCopy);
            if (!meno.contains(key)) {
                meno.add(key);
                result.add(itemCopy);
            }
        }

        return result;
    }

    public String genKey(List<Integer> array) {
        String str = "";
        for (int i=0; i<array.size(); i++) {
            if (i == 0) {
                str = str + array.get(i);
            } else {
                str = str + "-" + array.get(i);
            }
        }
        return str;
    }
}
