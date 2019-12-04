package cn.zhueian.algorithm.其他;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qiucy on 2019/12/4.
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 示例:

 输入: [1,2,3,null,5,null,4]
 输出: [1, 3, 4]
 解释:

        1            <---
      /   \
     2     3         <---
     \     \
     5     4       <---

 */
public class T199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        get(res,root);
        return res;
    }

    private void get(List<Integer> res, TreeNode node) {
        TreeNode right = node.right;
        if (right == null){
            if (node.left!= null) res.add(node.left.val);
            return;
        }
        res.add(right.val);
        get(res,right);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> t = new LinkedList<>();
        t.add(root);
        while (!t.isEmpty()){
            int size = t.size();
            TreeNode peek = t.peek();
            res.add(peek.val);
            for (int i = 0; i < size; i++) {
                TreeNode poll = t.poll();
                if (poll.right!=null) t.add(poll.right);
                if (poll.left!=null) t.add(poll.left);
            }
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
