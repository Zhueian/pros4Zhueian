package cn.zhueian.leetcode.leetcode.conti.bfsAndDfs;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: qiucy
 * @Date: 2019-03-27 14:39
 * @Description:
 */

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class T279_完全平方数 {

    public static void main(String[] args) {
        new T279_完全平方数().numSquares2(12);
    }
    public int numSquares(int n) {
        int maxSqrt = (int)Math.sqrt(n);
        if(maxSqrt*maxSqrt == n) return 1;
        List<Integer> ttt = new ArrayList<>();
        for(int i = 1;i <= maxSqrt;i++){
            ttt.add(i*i);
        }

        return 0;
    }
    public int numSquares2(int n) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
//                res[i] = Math.min(res[i], res[i - j * j] + 1);
                int re = res[i];
                int re2 = res[i - j*j]+1;
                int min = Math.min(re, re2);
                res[i] = min;
            }
        }
        return res[n];
    }

}
