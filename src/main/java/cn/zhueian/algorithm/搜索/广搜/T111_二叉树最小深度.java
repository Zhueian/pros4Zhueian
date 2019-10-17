package cn.zhueian.algorithm.搜索.广搜;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiucy on 2019/10/16.
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

      3
     / \
     9  20
       /  \
      15   7
 返回它的最小深度  2.

 */
public class T111_二叉树最小深度 {
    public int minDepth(TreeNode root) {
        int var1 = 0;
        if (root == null) return var1;
        Queue<TreeNode> var2 = new LinkedList<>();
        var2.add(root);
        for(;!var2.isEmpty();){
            int size = var2.size();
            var1++;
            for (int i = 0; i < size; i++) {
                TreeNode var3 = var2.poll();
                TreeNode left = var3.left;
                TreeNode right = var3.right;
                if (left == null && right == null) return var1;
                if (left!=null) var2.add(left);
                if (right!=null) var2.add(right);
            }
        }
        return var1;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

