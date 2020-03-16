package cn.zhueian.algorithm.其他;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qiucy on 2020/1/8.
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

 （这里，平面上两点之间的距离是欧几里德距离。）

 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

  

 示例 1：

 输入：points = [[1,3],[-2,2]], K = 1
 输出：[[-2,2]]
 解释：
 (1, 3) 和原点之间的距离为 sqrt(10)，
 (-2, 2) 和原点之间的距离为 sqrt(8)，
 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 示例 2：

 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 输出：[[3,3],[-2,4]]
 （答案 [[-2,4],[3,3]] 也会被接受。）
 */
public class T973_最接近远点的k个点 {
    public static int[][] kClosest(int[][] points, int K) {
        int length = points.length;
        int[][] ans = new int[K][2];
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        for (int i = 0; i < K; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{3,3},{5,-1},{-2,4}};
        int[][] ints = kClosest(a, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i][0]+","+ints[i][1]);
        }
    }

    public int[][] kClosestQuickSort(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }


    //最骚
    public int[][] kClosestSao(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}
