package cn.zhueian.leetcode.leetcode.ac;

/**
 * @Auther: qiucy
 * @Date: 2019-03-10 18:18
 * @Description:
 */
public class T633_平方数之和 {
    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     *
     * 示例1:
     *
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     *
     *
     * 示例2:
     *
     * 输入: 3
     * 输出: False
     */
    public static void main(String[] args) {
        new T633_平方数之和().judgeSquareSum(4);
    }

    /**
     * best
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if(c<0) return false;
        int right = (int)Math.sqrt(c),left = 0;
        while(left <= right){
            if(right*right + left*left > c){
                right --;
            }else if(right*right + left*left < c){
                left ++;
            }else{
                return true;
            }
        }
        return false;
    }
}
