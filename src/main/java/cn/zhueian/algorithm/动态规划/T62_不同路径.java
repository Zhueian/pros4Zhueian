package cn.zhueian.algorithm.动态规划;

/**
 * Created by qiucy on 2019/12/26.
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 问总共有多少条不同的路径？



 例如，上图是一个7 x 3 的网格。有多少可能的路径？

 说明：m 和 n 的值均不超过 100。

 示例 1:

 输入: m = 3, n = 2
 输出: 3
 解释:
 从左上角开始，总共有 3 条路径可以到达右下角。
 1. 向右 -> 向右 -> 向下
 2. 向右 -> 向下 -> 向右
 3. 向下 -> 向右 -> 向右
 示例 2:

 输入: m = 7, n = 3
 输出: 28
 */
public class T62_不同路径 {
    //0->下；1->右。。组合,公式:C(m+n-2,min(m-1,n-1))
    //C(k,n)=n(n-1)(n-2)(n-3).(n-k+1)/k!
    public int uniquePaths(int m, int n) {
        int k = m+n-2;
        int ansN = Math.min(m-1,n-1);
        if (ansN == 0) return 1;
        int ans = 1;
        int up = k;
        int down = ansN;
        for (int i = 1; i < ansN; i++) {
            up *= (m + n -2-i);
            down *= (ansN-i);
        }
        return up/down;
    }

    //db，最小路径和那味了
    public int dp(int m ,int n){
        if (m == 1 || n == 1) return 1;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) grid[i][j] = 1;
                if (j == 0) grid[i][j] = 1;
                if (i != 0 && j != 0) grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

}
