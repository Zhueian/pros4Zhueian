package cn.zhueian.algorithm.其他;

import java.util.Arrays;

/**
 * Created by qiucy on 2020/1/8.
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

  

 示例 1：

 输入：[-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 示例 2：

 输入：[-7,-3,2,3,11]
 输出：[4,9,9,49,121]
  

 提示：

 1 <= A.length <= 10000
 -10000 <= A[i] <= 10000
 A 已按非递减顺序排序。
 */
public class T977_有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = A[i]*A[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
