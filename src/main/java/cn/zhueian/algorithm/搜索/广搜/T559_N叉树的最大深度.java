package cn.zhueian.algorithm.搜索.广搜;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qiucy on 2019/10/15.
 * 给定一个 N 叉树，找到其最大深度。

 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

 例如，给定一个 3叉树 :

 我们应返回其最大深度，3。

 说明:

 树的深度不会超过 1000。
 树的节点总不会超过 5000。

 */
public class T559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return 0;
        Node curr = root;
        Queue<Node> temp = new LinkedList<>();
        temp.add(root);
        int level = 0;
        while (!temp.isEmpty()){
            level++;
            int size = temp.size();
            for (int i = 0;i<size;i++){
                Node val = temp.poll();
                List<Node> children = val.children;
                if (children!=null && !children.isEmpty()){
                    temp.addAll(children);
                }
            }
        }
        return level;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
