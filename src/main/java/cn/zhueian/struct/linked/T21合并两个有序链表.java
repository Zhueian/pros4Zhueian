package cn.zhueian.struct.linked;

/**
 * Created by qiucy on 2020/1/15.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class T21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode initNode = new ListNode(-1);

        while (l1 != null && l2 != null){
            if (l1 == null){

            }
        }
        return initNode;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
