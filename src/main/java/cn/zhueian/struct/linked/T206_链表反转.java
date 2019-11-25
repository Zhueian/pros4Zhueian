package cn.zhueian.struct.linked;

import java.util.Stack;

/**
 * Created by qiucy on 2019/10/31.
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 */
public class T206_链表反转 {
    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        return null;
    }
    private ListNode t(ListNode k){
        if (k.next!=null){
            ListNode n = k.next;
            n.next = k;
        }
        return null;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
