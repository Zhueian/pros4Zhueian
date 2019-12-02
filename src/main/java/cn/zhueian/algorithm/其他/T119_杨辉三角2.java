package cn.zhueian.algorithm.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiucy on 2019/12/2.
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。
 示例:
 [
        [1],
       [1,1],
      [1,2,1],
     [1,3,3,1],
    [1,4,6,4,1]
 ]
 输入: 3
 输出: [1,3,3,1]
 进阶：

 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class T119_杨辉三角2 {
    private static List<List<Integer>> res = new ArrayList<>();
    static {
        a:for (int i = 0; i < 34; i++) {
            if (i == 0){
                ArrayList<Integer> t = new ArrayList<>();
                t.add(1);
                res.add(t);
            }
            else if (i == 1){
                ArrayList<Integer> t = new ArrayList<>();
                t.add(1);
                t.add(1);
                res.add(t);
            }else {
                ArrayList<Integer> t = new ArrayList<>();
                List<Integer> integers = res.get(i - 1);
                int size = integers.size();
                t.add(1);
                for (int j = 0; j < size - 1; j++) {
                    t.add(integers.get(j) + integers.get(j + 1));
                }
                t.add(1);
                res.add(t);
            }
        }
    }
    public List<Integer> getRow(int rowIndex) {
        return res.get(rowIndex);
    }
}
