package cn.zhueian.algorithm.搜索;

/**
 * Created by qiucy on 2019/10/14.
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

      1
     / \
    2   2
   / \ / \
  3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

       1
      / \
     2  2
     \  \
     3  3

 */
public class T101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
