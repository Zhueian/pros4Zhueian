package cn.zhueian.algorithm.搜索.深搜;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by qiucy on 2019/10/17.
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

      3
     / \
     9  20
     /  \
    15   7
 返回它的最大深度 3 。

 */
public class T104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        int res = 0;
        Stack<TreeNode> comPlace = new Stack<>();
        Map<TreeNode,Integer> temp = new HashMap<>();
        comPlace.push(root);
        for (;!comPlace.isEmpty();){
            TreeNode pop = comPlace.pop();
            TreeNode left = pop.left;
            TreeNode right = pop.right;
            if (left!=null){
                comPlace.push(left);

            }
            if (right!=null){
                comPlace.push(right);
            }
        }
        return res;
    }
    public int maxDepth2(TreeNode root) {
        return root == null?0:1+Math.max(maxDepth2(root.left),maxDepth2(root.right));
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
