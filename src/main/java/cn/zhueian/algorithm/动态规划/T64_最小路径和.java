package cn.zhueian.algorithm.动态规划;

/**
 * Created by qiucy on 2019/11/25.
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
  [1,3,1],
  [1,5,1],
  [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class T64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int l1 = grid.length;
        int l2 = grid[0].length;
        for (int i = 0;i<l1;i++){
            for (int j = 0;j<l2;j++){
                if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j-1];
                if (i != 0 && j == 0)
                    grid[i][j] += grid[i-1][j];
                if (i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[l1-1][l2-1];
    }
}
