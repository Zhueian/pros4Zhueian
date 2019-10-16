package cn.zhueian.algorithm.搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qiucy on 2019/10/16.
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

      3
     / \
     9  20
     /  \
    15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class T102_二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        for (;!temp.isEmpty();){
            int size = temp.size();
            List<Integer> var1 = new ArrayList<>();
            for (int i = 0;i<size;i++){
                TreeNode poll = temp.poll();
                var1.add(poll.val);
                if (poll.left!=null)
                    temp.add(poll.left);
                if (poll.right!=null)
                    temp.add(poll.right);
            }
            res.add(var1);
        }
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
