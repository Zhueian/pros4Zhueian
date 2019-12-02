package cn.zhueian.algorithm.其他;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by qiucy on 2019/11/28.
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]
 */
public class T78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
//        for (int i = 0;i<length;i++){
//            for (int j = 0; j < i; j++) {
//
//            }
//        }
        resur(nums,res);
        return res;
    }
    private List<Integer> resur(int[] nums,List<List<Integer>> res){
        return null;
    }




}
