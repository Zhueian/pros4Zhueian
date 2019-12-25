package cn.zhueian.algorithm.其他;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiucy on 2019/12/9.
 * 翻转一棵二叉树。

 示例：

 输入：

        4
      /   \
    2     7
   / \   / \
 1   3 6   9
 输出：

        4
      /   \
    7     2
   / \   / \
  9   6 3   1

 */
public class T226_反转二叉树 {
    //宽搜
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left!=null) queue.add(left);
                if (right!=null) queue.add(right);
                poll.left = right;
                poll.right = left;
            }
        }
        return root;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //[4,2,7,1,3,6,9]
    //输出
    //[4,7,2,6,9,1,3]
    //预期结果
    //[4,7,2,9,6,3,1]
}
