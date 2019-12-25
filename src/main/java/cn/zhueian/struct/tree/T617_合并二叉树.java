package cn.zhueian.struct.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiucy on 2019/12/23.
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 否则不为 NULL 的节点将直接作为新二叉树的节点。
 示例 1:

 输入:
 Tree 1                     Tree 2
      1                         2
     / \                       / \
    3   2                     1   3
   /                           \   \
  5                             4   7
 输出:
 合并后的树:
         3
        / \
       4   5
      / \   \
     5   4   7

 */
public class T617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        bfsMerge(t1,t2);
        return t1;
    }

    private void bfsMerge(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val = t1.val+t2.val;
            bfsMerge(t1.left,t2.left);
            bfsMerge(t1.right,t2.right);
            return;
        }else if (t1 == null && t2 != null) {
            t1 = t2;
            bfsMerge(null,t2.left);
            bfsMerge(null,t2.right);
            return;
        }else if (t1 != null && t2 == null){
            bfsMerge(t1.left,null);
            bfsMerge(t1.right,null);
        }

    }


    //bfs
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(t1);
        q2.add(t2);
        while (!q1.isEmpty() || !q2.isEmpty()){
            TreeNode p1 = q1.poll();
            TreeNode p2 = q2.poll();
            if (p1!=null && p2!=null){
                if (p1 != null){
                    if (p1.left != null) q1.add(p1.left);
                    if (p1.right != null) q1.add(p1.right);
                }else {
                    q1.add(new TreeNode(-666));
                }
                if (p2 != null){
                    if (p2.left != null) q2.add(p2.left);
                    if (p2.right != null) q2.add(p2.right);
                }else {
                    q2.add(new TreeNode(-666));
                }
                if (p1 == null && p2 == null);
                if (p1 == null && p2 != null) p1 = p2;
                if (p1 != null && p2 == null);
                if (p1 != null && p2 != null) p1.val = p1.val+p2.val;
            }

        }
        bfsCLs(t1);
        return t1;
    }

    private void bfsCLs(TreeNode t1) {
//        if (t1!=null) {
//            if (t1.val == -666){
//                t1 =
//            }
//        }
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
