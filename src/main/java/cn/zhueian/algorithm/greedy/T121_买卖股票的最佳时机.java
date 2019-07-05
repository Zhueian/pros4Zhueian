package cn.zhueian.algorithm.greedy;

/**
 * @Auther: qiucy
 * @Date: 2019-07-04 14:03
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class T121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int r = 0,l = prices.length;
        for (int i = 0; i < l-1; i++) {
            for (int j = i+1; j < l; j++) {
                int win = prices[j] - prices[i];
                if (win > 0) r=win>r?win:r;
            }
        }
        return r;
    }
    //kadane舒徐归纳法
    public static int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    public static int maxProfit3(int[] prices){
        if (prices == null) return 0;
        int l = prices.length;
        if (l <= 1) return 0;
        int max = 0,min = 0;
        for (int i = 0; i < l; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(prices[i],min);
        }
        return max;
    }


    public static void main(String[] args) {
        maxProfit2(new int[]{7,1,5,3,6,4});
    }
}
