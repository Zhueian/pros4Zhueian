package cn.zhueian.algorithm.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiucy on 2019/12/2.
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。
 示例:
 输入: 5
 输出:
 [
        [1],
       [1,1],
      [1,2,1],
     [1,3,3,1],
    [1,4,6,4,1]
 ]
 */
public class T_118杨辉三角 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        a:for (int i = 0; i < numRows; i++) {
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
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
