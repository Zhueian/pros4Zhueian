package cn.zhueian.struct.array;

import java.util.HashMap;

/**
 * @Auther: qiucy
 * @Date: 2019-07-01 09:44
 * @Description:和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 */
public class T594_最长和谐子序列 {
    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //堆排序
        //       int[] countSort = new int [10];
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int l = 0;
        for (Integer k:map.keySet()){
            if (map.containsKey(k+1))
                l = Math.max(map.get(k)+map.get(k+1),l);
        }
        return l;
    }

    public static void main(String[] args) {
        int lhs = findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println(lhs);
    }
}
