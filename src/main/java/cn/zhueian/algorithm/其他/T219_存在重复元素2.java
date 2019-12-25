package cn.zhueian.algorithm.其他;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qiucy on 2019/12/10.
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

 示例 1:

 输入: nums = [1,2,3,1], k = 3
 输出: true
 示例 2:

 输入: nums = [1,0,1,1], k = 1
 输出: true
 示例 3:

 输入: nums = [1,2,3,1,2,3], k = 2
 输出: false

 */
public class T219_存在重复元素2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        List<Integer> get = new ArrayList();
        boolean res = false;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(nums[i] == nums[j] && Math.abs(i-j)<=k) return true;
//                    get.add(Math.abs(i-j));

            }
        }
//        Collections.sort(get);
//        return get.contains(k);

        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,1};
        containsNearbyDuplicate(a,1);
    }
}
