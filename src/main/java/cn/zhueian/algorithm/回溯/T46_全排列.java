package cn.zhueian.algorithm.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qiucy on 2019/11/27.
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 permutations
 */
public class T46_全排列 {

    public static void main(String[] args){
//        int[] nums={1};
        int[] nums={1,2};
        System.out.println((new T46_全排列()).permute(nums));
    }

    //默写程序
    public List<List<Integer>> permute(int[]  in){
        List<List<Integer>> ans = new ArrayList<>();
        if (in == null || in .length == 0) return ans;
        recall(ans,new ArrayList<Integer>(),new HashSet<Integer>(),in);
        return ans;
    }
    //去重
    private void recall(List<List<Integer>> ans, List<Integer> currList, Set<Integer> filter,int[] in){
        if (in.length == currList.size()) ans.add(new ArrayList<>(currList));
        else {
            for (int i = 0; i < in.length; i++) {
                if (filter.add(in[i])){
                    currList.add(in[i]);
                    recall(ans,currList,filter,in);
                    filter.remove(in[i]);
                    currList.remove(currList.size()-1);
                }
            }
        }
    }
}
