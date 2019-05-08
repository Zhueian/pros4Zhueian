package cn.zhueian.leetcode.leetcode.ac;

/**
 * @Auther: qiucy
 * @Date: 2019-04-29 17:53
 * @Description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，
 * 如果反转后整数溢出那么就返回 0。
 */
public class T07_ReverseInteger {
    public int reverse(int x) {
        if(x<10 && x > -10) return x;
        if(x > 0){
            long i = Long.parseLong(new StringBuffer("" + x).reverse().toString());
            if(i>(long)(Math.pow(2,31)-1) ){
                return 0;
            }
            return (int)i;
        }else{
            //TODO  x*(-1L)??嘛操作
            long i = -Long.parseLong(new StringBuffer((x*(-1L))+"").reverse().toString());
            if(i<-(long)(Math.pow(2,31)) ){
                return 0;
            }
            return (int)i;
        }
    }

    public static void main(String[] args) {
//        int reverse = new T07_ReverseInteger().reverse(1534236469);
        int reverse = new T07_ReverseInteger().reverse(-2147483648);
        System.out.println(reverse);
        System.out.println(Math.pow(2,3));
    }
}
