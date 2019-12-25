package cn.zhueian.struct.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by qiucy on 2019/12/25.
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

 说明：
 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

 示例 1:

 输入: root = [3,1,4,null,2], k = 1
            3
           / \
          1   4
           \
            2
 输出: 1
 示例 2:

 输入: root = [5,3,6,2,4,null,null,1], k = 3
            5
           / \
          3   6
         / \
        2   4
       /
      1

 */
public class T230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> temp = new ArrayList<>();
        dfs(root,temp);
        Collections.sort(temp);
        return temp.get(k-1);
    }

    private void dfs(TreeNode node, List<Integer> temp) {
        if (node != null){
            temp.add(node.val);
            dfs(node.left,temp);
            dfs(node.right,temp);
        }
    }

    //best搜索树中序便利第前k个元素就是，递归遍历
    private List<Integer> nodeList = new ArrayList<>();

    public int kthSmallest1(TreeNode root, int k) {
        traversalTree1(root);
        return this.nodeList.get(k - 1);
    }

    public void traversalTree1(TreeNode root) {
        if (root != null) {
            traversalTree1(root.left);
            this.nodeList.add(root.val);
            traversalTree1(root.right);
        }
    }
    //迭代遍历
    public void traversalTree12(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                this.nodeList.add(node.val);
                if (root != null) {
                    root = node.right;
                }
            }
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
