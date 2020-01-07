package cn.zhueian.algorithm.动态规划;

/**
 * Created by qiucy on 2020/1/7.
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 给定 N，计算 F(N)。

  

 示例 1：

 输入：2
 输出：1
 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 示例 2：

 输入：3
 输出：2
 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 示例 3：

 输入：4
 输出：3
 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class T500_斐波那契 {

    //栈内存溢出
    public static int fib(int N) {
        if (N == 1) return 1;
        if (N == 2) return 1;
        return fib(N-1)+fib(N-2);
    }


    //记忆迭代法
    public static int fib2(int N){
        if (N == 0) return 0;
        if (N <= 2) return 1;
        int ans = 0;
        ans = helper(N);
        return ans;
    }

    private static int helper(int n) {
        int[] helper = new int[n];
        helper[0] = 1;
        helper[1] = 1;
        for (int i = 2; i < n; i++) {
            helper[i] = helper[i-1]+helper[i-2];
        }
        return helper[n-1];
    }

    public static void main(String[] args) {
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
    }
}
