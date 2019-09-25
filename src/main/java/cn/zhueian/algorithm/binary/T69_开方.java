package cn.zhueian.algorithm.binary;

/**
 * Created by qiucy on 2019/9/25.
 * 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。
 */
public class T69_开方 {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 3) return 1;
        long mid = x/2;
        for (long i = 1;i <= mid+1;i++){
            if (i*i>x) {
                int r = (int)i-1;
                return r;
            }
            if (i*i == x){
                int r = (int)i;
                return r;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

//        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrt(80));
    }
}
