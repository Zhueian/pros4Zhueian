package cn.zhueian.leetcode.leetcode.ac;

/**
 * @Auther: qiucy
 * @Date: 2019-03-08 13:49
 * @Description:
 */
public class T283_移动零 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public static void main(String[] args) {
        System.out.println("qweqwe1");
        int intArray[] = {0,1,0,3,12};
        new T283_移动零().moveZeroes(intArray);
    }
    public void moveZeroes(int[] nums) {
        //冒泡排序思路
        int length = nums.length;
        a:for(int i = 0;i<length;i++){
            if(nums[i] == 0){
                for(int j = i;j<length-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[length-1] = 0;
                i = -1;
                length--;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
    /**
     * best
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
