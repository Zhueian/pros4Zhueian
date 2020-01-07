package cn.zhueian.algorithm.动态规划;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by qiucy on 2019/12/16.
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

  

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class T239_滑动窗口 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int l = nums.length-k+1;
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            int[] t = subArr(nums,i,k);
            Arrays.sort(t);
            ans[i] = t[t.length-1];
        }
        return ans;
    }

    private int[] subArr(int[] nums, int i, int k) {
        int[] t = new int[k];
        for (int j = 0; j < k; j++) {
            t[j] = nums[i+j];
        }
        return t;
    }
    //动态规划
    public static int[] maxSlidingWindow2(int[] a, int k) {
        int n = a.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return a;

        int [] left = new int[n];
        left[0] = a[0];
        int [] right = new int[n];
        right[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = a[i];  // block_start
            else left[i] = Math.max(left[i - 1], a[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = a[j];  // block_end
            else right[j] = Math.max(right[j + 1], a[j]);
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow2(a, 3);
        for (int s:ints){
            System.out.print(s+" ");
        }
    }
}
