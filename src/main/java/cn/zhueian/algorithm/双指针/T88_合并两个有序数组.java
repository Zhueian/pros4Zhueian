package cn.zhueian.algorithm.双指针;

import java.util.Arrays;

/**
 * Created by qiucy on 2019/8/22.
 * 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
public class T88_合并两个有序数组 {
    /**
     * myWay
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void  merge(int[] nums1, int m, int[] nums2, int n) {
        int[] t = new int[m+n];
        int f1 = 0,f2 = 0;
        for (int i = 0; i < m+n && f1<m; i++) {
            if (nums1[f1]>nums2[f2]){
                t[i] = nums2[f2];
                ++f2;
            }else{
                t[i] = nums1[f1];
                ++f1;
            }
        }
        nums1 = t;
        for (int i = 0; i < t.length; i++) System.out.print(t[i]+" ");
        System.out.println();
        for (int i = 0; i < t.length; i++) System.out.print(nums1[i]+" ");
    }

    /**
     * best way
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge2(int A[], int m, int B[], int n) {
        while(n > 0) A[m+n-1] = (m == 0 || A[m-1] < B[n-1]) ? B[--n] : A[--m];
    }

    /**
     * dickway
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * [1,2,4,5,6,0]
        5
        [3]
        1
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n){
        if (nums2.length<=0 || nums2 == null) return;
        for (int i = m,k = -1;i < nums1.length;i++) nums1[i] = nums2[++k];
        for (int i = 0; i < nums1.length; i++) System.out.print(nums1[i]+" ");
        System.out.println();
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) System.out.print(nums1[i]+" ");
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
    }
}
