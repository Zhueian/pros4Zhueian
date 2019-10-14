package cn.zhueian.algorithm.binary;

/**
 * Created by qiucy on 2019/9/30.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。

 示例 1:

 输入: [3,4,5,1,2]
 输出: 1
 示例 2:

 输入: [4,5,6,7,0,1,2]
 输出: 0
 */

public class T153寻找旋转排序数组中的最小值 {
    /**
     * binary O(logn)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length,l = 0;
        for (int r = len-1;l<r;){
            int m = l+(r-l)/2;
            if (nums[m] > nums[l]){

            }else if (nums[m] < nums[l]){

            }
        }
        return l;
    }

    /**
     * O(n)
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
//        if (nums.length  == 1) return nums[0];
        int i = 0;
        for (;i < nums.length-1; i++) {
            if (nums[i]>nums[i+1])
                return nums[i+1];
        }
        return nums[0];
    }
}
