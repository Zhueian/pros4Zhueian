package cn.zhueian.algorithm.搜索.深搜;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiucy on 2019/12/12.
 * 给定两个二叉树，编写一个函数来检验它们是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

 示例 1:

 输入:       1         1
           / \       / \
          2   3     2   3

       [1,2,3],   [1,2,3]

 输出: true
 示例 2:

 输入:      1          1
          /           \
         2             2

       [1,2],     [1,null,2]

 输出: false
 示例 3:

 输入:       1         1
           / \       / \
          2   1     1   2

        [1,2,1],   [1,1,2]

 输出: false
 */
public class T100_相同的树 {
    //宽搜
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        Queue<TreeNode> t1 = new LinkedList<>();
        Queue<TreeNode> t2 = new LinkedList<>();

        return false;
    }
    //深搜
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        StringBuffer sbfp = new StringBuffer();
        StringBuffer sbfq = new StringBuffer();
        dfs(p,sbfp);
        dfs(q,sbfq);
        return sbfp.toString().equals(sbfq.toString());
    }

    private void dfs(TreeNode node, StringBuffer sbf) {
        if (node == null) sbf.append("x");
        else {
            sbf.append(node.val+"");
            dfs(node.left,sbf);
            dfs(node.right,sbf);
        }
    }

    //leetcode best
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        s1.append("asd");
        s2.append("asd");
        System.out.println(s1.toString().equals(s2.toString()));
    }
}
