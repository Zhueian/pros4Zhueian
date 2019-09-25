package cn.zhueian.algorithm.binary;

import java.util.HashSet;

/**
 * Created by qiucy on 2019/9/25.
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

 示例 1:

 输入: [1,1,2,3,3,4,4,8,8]
 输出: 2
 示例 2:

 输入: [3,3,7,7,10,11,11]
 输入: [1，1，3,3,7,7,10,11,11，12，12]
 输出: 10
 */
public class T540_有序数组中的单一元素 {
    /**
     * hash
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            if (!set.add(nums[i])) set.remove(nums[i]);
        return set.iterator().next();
    }
    /**
     * BINARY
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int l = nums.length;
        int mid = l/2;
        if (nums[mid] == nums[mid-1]){

        }else if(nums[mid] == nums[mid+1){

        }else return nums[mid];
    }
    public static void main(String[] args) {

    }
}
