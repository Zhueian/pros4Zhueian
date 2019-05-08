package cn.zhueian.leetcode.leetcode.ac;

import java.util.Arrays;

/**
 * @Auther: qiucy
 * @Date: 2019-03-09 17:05
 * @Description:
 */
public class T455_分发饼干 {
    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
     * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，
     * 这个孩子会得到满足。
     *
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 注意：
     *
     * 你可以假设胃口值为正。
     * 一个小朋友最多只能拥有一块饼干。
     *
     * 示例 1:
     *
     * 输入: [1,2,3], [1,1]
     *
     * 输出: 1
     *
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     *
     * 输入: [1,2], [1,2,3]
     */
    public static void main(String[] args) {
        //贪心算法：贪心思想保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
        int[] g = {1,2,3,1,1,4,2,3};
        int[] s = {1,2,3,8,4,1,2};
        new T455_分发饼干().findContentChildren(g,s);
    }
    //g:孩子 s：饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j = 0;i < g.length && j < s.length;j++){
            if(s[j] >= g[i]) i++;
        }
        return i;
    }
}
