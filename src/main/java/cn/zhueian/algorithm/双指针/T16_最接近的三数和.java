package cn.zhueian.algorithm.双指针;

/**
 * Created by qiucy on 2020/1/8.
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。

 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 */
public class T16_最接近的三数和 {
    //O(n^3)
    public int threeSumClosest(int[] nums, int target) {
        int t = Integer.MAX_VALUE;
        int ans = 0;
        int length = nums.length;
        a:for (int i = 0; i < length; i++) {
            b:for (int j = 0; j < length; j++) {
                if (j == i) continue b;
                c:for (int k = 0; k < length; k++) {
                    if (k == j || k == i) continue c;
                    int temp = nums[i]+nums[j]+ nums[k];
                    int abs = Math.abs(temp - target);
                    if (abs < t){
                        ans = temp;
                        t = abs;
                    }
                }
            }
        }
        return ans;
    }
    //双指针
    public int m(int[] nums, int target){
        int ans = 0;
        int length = nums.length;
        int right = length-1,left = 0;
        for (int i = 0; i < length; i++) {
            int mid = nums[i];
            while (right>left){

            }
        }

        return ans;
    }

}
