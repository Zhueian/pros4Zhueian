package cn.zhueian.algorithm.搜索.广搜;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        boolean res = true;
        if (root == null ) return res=true;
        Queue<TreeNode> var1 = new LinkedList<>();
        List<String> comPlace = new ArrayList<>();
        var1.add(root);
        for (;!var1.isEmpty();){
            comPlace.clear();
            int size = var1.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = var1.poll();
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                comPlace.add(left == null?"null":left.val+"");
                comPlace.add(right == null?"null":right.val+"");
                if (left!=null) var1.add(left);
                if (right!=null) var1.add(right);
            }
            for (int j = 0;j<comPlace.size()/2;j++)
                if (!comPlace.get(j).equals(comPlace.get(comPlace.size()-j-1))) return false;
        }
        return res;
    }

    /**
     * best
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
        T101_对称二叉树 t = new T101_对称二叉树();
        System.out.println(t.isSymmetric(null));

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
