package cn.zhueian.leetcode.leetcode.conti;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: qiucy
 * @Date: 2019-03-09 18:15
 * @Description:
 */
public class T435_无重叠区间 {
    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     *
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     *
     * 输入: [ [1,2], [1,2], [1,2] ]
     *
     * 输出: 2
     *
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     *
     * 输入: [ [1,2], [2,3] ]
     *
     * 输出: 0
     *
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     */
    int start;
    int end;
    T435_无重叠区间(){
        start = 0;
        end = 0;
    }
    T435_无重叠区间(int s,int e){
        start = s;
        end = e;
    }
}
class Solution {
    public int eraseOverlapIntervals(T435_无重叠区间[] intervals) {
//        if(intervals.length < 1) return 0;
//        Arrays.parallelSort(intervals, new Comparator<T435_无重叠区间>() {
//            @Override
//            public int compare(T435_无重叠区间 o1, T435_无重叠区间 o2) {
//                return o1.start-o2.start;
//            }
//        });

        Arrays.sort(intervals, new Comparator<T435_无重叠区间>() {
            @Override
            public int compare(T435_无重叠区间 o1, T435_无重叠区间 o2) {
                if (o1.end != o2.end) return o1.end - o2.end;  //first sort by end
                return o2.start - o1.start;  //second sort by start
            }
        });
        for (T435_无重叠区间 interval : intervals) {
            System.out.println(interval);
        }
        int result = 0;
//        for(int i = 0;i < intervals.length-1;i++){
//            if(intervals[i].end < intervals[i+1].start){
//                result++;
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        T435_无重叠区间 a = new T435_无重叠区间(1, 2);
        T435_无重叠区间 b = new T435_无重叠区间(1, 2);
        T435_无重叠区间 c = new T435_无重叠区间(1, 2);
        T435_无重叠区间 d = new T435_无重叠区间(1, 2);
        T435_无重叠区间 e = new T435_无重叠区间(1, 2);
        T435_无重叠区间 f = new T435_无重叠区间(1, 2);
        T435_无重叠区间[] arr = {a,b,c,d,e,f};
        new Solution().eraseOverlapIntervals(arr);
    }
}

