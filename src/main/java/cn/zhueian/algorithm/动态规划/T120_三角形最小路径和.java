package cn.zhueian.algorithm.动态规划;

import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qiucy on 2019/11/26.
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 例如，给定三角形：

 [
    [-1],
    [2,3],
  [1,-1,-3],
 ]
 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 说明：

 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

 */
public class T120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = triangle.get(0).get(0);
        int size = triangle.size();
        if (size == 1) return res;
        for (int i = 1;i<triangle.size();i++){
            List<Integer> integers = triangle.get(i);
            int s = integers.size();
            for (int j = 0;j < s;j++){
                if (j == 0)
                    integers.add(0,integers.get(0)+triangle.get(i-1).get(0));
                else if (j == s-1)
                    integers.add(s-1,integers.get(s-1)+triangle.get(i-1).get(triangle.get(i-1).size()-1));
                else
                    integers.add(j,integers.get(j)+Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
                integers.remove(j+1);
            }
        }
        List<Integer> integers = triangle.get(triangle.size() - 1);
        Collections.sort(integers);
        return integers.get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        ArrayList<Integer> is = new ArrayList<>();
        is.add(1);
        is.add(3);
        is.add(-9);
        Collections.sort(is);
        is.forEach(System.out::println);
        is.add(0,2);
        System.out.println("---");
        is.forEach(System.out::println);
    }
}
