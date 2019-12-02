package cn.zhueian.algorithm.其他;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by qiucy on 2019/12/2.
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

 说明: 叶子节点是指没有子节点的节点。

 示例: 
 给定如下二叉树，以及目标和 sum = 22，

           5
          / \
         4   8
        /   / \
      11  13  4
     /  \      \
    7    2      1
 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class T112_路径总和 {

    //递归
    private boolean hasPathSum(TreeNode root,int val) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return val == root.val;
        return hasPathSum(root.left,val-root.val) || hasPathSum(root.right,val-root.val);
    }
    //DFS
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        while (!s.isEmpty()){
            int size = s.size();
            a:for (int i = 0 ;i < size;i++){
                TreeNode poll = s.poll();
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left == null && right == null){
                    if (sum == poll.val) return true;
                    else continue a;
                }
                if (left != null){
                    left.val += poll.val;
                    s.add(left);
                }
                if (right != null){
                    right.val += poll.val;
                    s.add(right);
                }
            }

        }
        return false;
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
