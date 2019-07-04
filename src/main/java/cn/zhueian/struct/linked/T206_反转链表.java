package cn.zhueian.struct.linked;

/**
 * @Auther: qiucy
 * @Date: 2019-06-26 10:52
 * @Description:反转一个单链表。
     *进阶:
     * 你可以迭代或递归地反转链表
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class T206_反转链表 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        int count = 0;
        ListNode a = head;
        while (a!=null){
            a = a.next;
            count++;
        }
        return null;
    }
    //_src
    public ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList2(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("asdasd".split(",").length);
    }
}
