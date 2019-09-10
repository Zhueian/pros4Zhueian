package cn.zhueian.algorithm.greedy;

/**
 * @Auther: qiucy
 * @Date: 2019-07-12 15:33
 * @Description:
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * 示例 1:
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 */
public class T665_非递减区间 {
    public static boolean checkPossibility(int[] nums) {
        int c = 0,l=nums.length;
        if (l <= 2) return true;
        if (l == 3){
            for (int i = 1; i < l; i++) {
                if (nums[i - 1] > nums[i]) c++;
                if (c == 2) return false;
            }
        }else {
            for (int i = 0; i < l-1; i++) {
                if (nums[i] > nums[i+1]) {
                    if (i >= 1)
                        if (nums[i + 1] < nums[i - 1]) return false;
                        else nums[i] = nums[i+1];
                    c++;
                }
                if (c == 2) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {3,4,2,3};
//        int[] arr2 = {2,3,3,2,4};
//        int[] arr2 = {4,2,3};
//        int[] arr2 = {1,2,3,5,4};

//        int[] arr2 = {-1,4,2,3};

//        int[] arr2 = {2,1,3,5,4};
        int[] arr2 = {2,3,3,2,4};
        boolean b = checkPossibility(arr2);
        System.out.println(b);
    }
}
