package com.akiradunn.oj.leetcode;
import org.apache.commons.lang3.tuple.Pair;
/**
 * 此题暂时无法解决，用例只通过了一半（518 / 994 个通过的测试用例），暂时不再投入过多精力
 * 实质难点在于处理溢出
 * 29. 两数相除
 * 尝试过
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 *
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 *
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 *
 *
 * 提示：
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 2));
    }

    public static int divide(int dividend, int divisor) {
        int x = dividend;
        int y = divisor;
        if (x == Integer.MAX_VALUE && y == 1)
            return Integer.MAX_VALUE;
        if (x == Integer.MIN_VALUE && y == 1)
            return Integer.MIN_VALUE;
        boolean reversed = false;
        if (x > 0) {
            x = -1 * x;
            reversed = true;
        }

        if (y > 0) {
            y = -1 * y;
            reversed = !reversed;
        }

        if (x > y) {
            return 0;
        }

        // yz >=x
        // y(z+1) <x
        int l = x; //- 10
        int r = 0; // -3
        int result = 0;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);; // -7
            int z = -1 * mid; // -7
            Pair<Boolean, Integer> firstRes = quickMultiply(y, z);
            if (firstRes.getKey() && firstRes.getValue() < x) {
                l = mid + 1; // l= -5 -4
                continue;
            }

            Pair<Boolean, Integer> secondRes = quickMultiply(y, z + 1);
            if (secondRes.getKey() && secondRes.getValue()  >= x) {
                r = mid - 1;
                continue;
            }

            result = z;
            break;
        }

        return reversed ? -1 * result : result;
    }

    public static Pair<Boolean, Integer> quickMultiply(int y, int z) {
        int result = 0;
        while (z != 0) {
            if ((z & 1) != 0) {
                if (result < Integer.MIN_VALUE - y) {
                    return Pair.of(false, Integer.MIN_VALUE);
                }
                result += y;
            }
            if (y < (Integer.MIN_VALUE >> 1)) {
                return Pair.of(false, Integer.MIN_VALUE);
            }
            y <<= 1;
            z >>= 1;
        }
        return Pair.of(true, result);
    }
}