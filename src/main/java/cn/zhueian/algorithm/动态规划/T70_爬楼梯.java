package cn.zhueian.algorithm.动态规划;

/**
 * Created by qiucy on 2019/12/27.
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶
 */
public class T70_爬楼梯 {
    public int climbStairs(int n) {
        int[] currToStep = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) currToStep[i] = 1;
            if (i == 1) currToStep[i] = 2;
            if (i != 0 && i != 1) currToStep[i] = currToStep[i-1]+currToStep[i-2];
        }
        return currToStep[n-1];
    }

    /**
     * 长度较短的有限集合的解，可直接返回值，自己学习算法最终的目的还是为了更好地解决问题。
        警醒自己不要沉迷于算法的精妙而忽视实际情况，上了很好的一课。
     * @param n
     * @return
     */
    public int best(int n) {
        int result = 0;

        switch(n){
            case 1: result = 1; break;
            case 2: result = 2; break;
            case 3: result = 3; break;
            case 4: result = 5; break;
            case 5: result = 8; break;
            case 6: result = 13; break;
            case 7: result = 21; break;
            case 8: result = 34; break;
            case 9: result = 55; break;
            case 10: result = 89; break;
            case 11: result = 144; break;
            case 12: result = 233; break;
            case 13: result = 377; break;
            case 14: result = 610; break;
            case 15: result = 987; break;
            case 16: result = 1597; break;
            case 17: result = 2584; break;
            case 18: result = 4181; break;
            case 19: result = 6765; break;
            case 20: result = 10946; break;
            case 21: result = 17711; break;
            case 22: result = 28657; break;
            case 23: result = 46368; break;
            case 24: result = 75025; break;
            case 25: result = 121393; break;
            case 26: result = 196418; break;
            case 27: result = 317811; break;
            case 28: result = 514229; break;
            case 29: result = 832040; break;
            case 30: result = 1346269; break;
            case 31: result = 2178309; break;
            case 32: result = 3524578; break;
            case 33: result = 5702887; break;
            case 34: result = 9227465; break;
            case 35: result = 14930352; break;
            case 36: result = 24157817; break;
            case 37: result = 39088169; break;
            case 38: result = 63245986; break;
            case 39: result = 102334155; break;
            case 40: result = 165580141; break;
            case 41: result = 267914296; break;
            case 42: result = 433494437; break;
            case 43: result = 701408733; break;
            case 44: result = 1134903170; break;
            case 45: result = 1836311903; break;

        }
        return result;
    }
    //bestsrc
    public int climbStairs3(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }
}
