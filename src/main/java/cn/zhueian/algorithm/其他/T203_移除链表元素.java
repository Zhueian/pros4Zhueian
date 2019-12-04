package cn.zhueian.algorithm.其他;

import java.util.LinkedList;

/**
 * Created by qiucy on 2019/12/4.
 * 删除链表中等于给定值 val 的所有节点。

 */
public class T203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tHead = head;
        if (head == null) return null;
        while (tHead != null ){
            if(tHead.val == val){
                tHead = tHead.next;
                continue;
            }else break;
        }
        if (tHead == null) return null;
        ListNode node = tHead;
        while (node.next != null){
            ListNode next = node.next;
            if (next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return tHead;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {

    }
}
