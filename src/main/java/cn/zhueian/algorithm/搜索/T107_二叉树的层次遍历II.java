package cn.zhueian.algorithm.搜索;

import java.util.*;

/**
 * Created by qiucy on 2019/10/16.
 * 与1相反的逻辑：从下而上bfs
 */
public class T107_二叉树的层次遍历II {
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
        Collections.reverse(res);
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
