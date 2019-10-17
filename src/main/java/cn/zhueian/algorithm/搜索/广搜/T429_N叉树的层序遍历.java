package cn.zhueian.algorithm.搜索.广搜;

import java.util.*;

/**
 * Created by qiucy on 2019/10/14.
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

 例如，给定一个 3叉树 :

 返回其层序遍历:

 [
 [1],
 [3,2,4],
 [5,6]
 ]

 说明:
 树的深度不会超过 1000。
 树的节点总数不会超过 5000。
 */
public class T429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Node curr = root;
        Queue<Node> temp = new LinkedList<>();
        temp.add(root);
        int level = 1;
        while (!temp.isEmpty()){
            int size = temp.size();
            List<Integer> levelVal = new ArrayList<>();
            for (int i = 0;i<size;i++){
                Node val = temp.poll();
                levelVal.add(val.val);
                List<Node> children = val.children;
                if (children!=null && !children.isEmpty()){
                    temp.addAll(children);
                }
            }
            res.add(levelVal);
        }
        return res;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
