package cn.zhueian.algorithm.其他;

/**
 * Created by qiucy on 2019/12/3.
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。

 示例 1:

 输入: 3
 输出: 0
 解释: 3! = 6, 尾数中没有零。
 示例 2:

 输入: 5
 输出: 1
 解释: 5! = 120, 尾数中有 1 个零.
 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class T172_阶乘后的零 {
//    public static int trailingZeroes(int n) {
//        int a = n/10;
//        int b = n%10;
//        if (b>=5) return 2*a+1;
//        return 2*a;
//    }

    public static int trailingZeroes(int n){
        return n == 0 ? 0 : n/5+trailingZeroes(n/5);
    }

    private static long get(long n) {
        return n == 1 ? 1 : get(n-1)*n;
    }

    public long trailingZeroes2(long n) {
        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        long i = get(20);
        System.out.println(i);
        System.out.println(trailingZeroes(20));

    }
}
