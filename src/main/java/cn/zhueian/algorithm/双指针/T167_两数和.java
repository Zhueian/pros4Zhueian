package cn.zhueian.algorithm.双指针;

/**
 * Created by qiucy on 2019/8/22.
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:

 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 */
public class T167_两数和 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0,right = numbers.length-1;
        int l = right;
        for (int i = 0; i < l && left<right; i++) {
            int t = numbers[left]+ numbers[right];
            if (t == target){
                res[0] = ++left;
                res[1] = ++right;
                break;
            }else if (t < target){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.println(twoSum(a,9)[0]);
        System.out.println(twoSum(a,9)[1]);
    }
}
