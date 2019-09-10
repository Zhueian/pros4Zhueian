package cn.zhueian.algorithm.greedy;

/**
 * @Auther: qiucy
 * @Date: 2019-07-15 09:59
 * @Description:给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class T53_子数组最大和 {
    //动态规划dp，跟股票1类似

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *  * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *  * 注意你不能在买入股票前卖出股票。
     *  * 示例 1:
     *  * 输入: [7,1,5,3,6,4]
     *  * 输出: 5
     *  * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *  *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *  * 示例 2:
     *  * 输入: [7,6,4,3,1]
     *  * 输出: 0
     *  * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        if (l == 1) return nums[0];
        int currM =nums[0],soFarM = nums[0];
        for (int i = 1; i < l; i++) {
            currM = Math.max(currM,nums[i]);
            soFarM = Math.max(soFarM,soFarM+currM);
        }
        return soFarM;
    }
}
